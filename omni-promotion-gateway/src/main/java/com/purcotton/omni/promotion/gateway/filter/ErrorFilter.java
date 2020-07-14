package com.purcotton.omni.promotion.gateway.filter;
import com.alibaba.fastjson.JSON;
import com.netflix.client.ClientException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.purcotton.omni.common.exception.CommonExceptionEnum;
import com.purcotton.omni.common.response.ErrorResponseData;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

@Component
public class ErrorFilter extends ZuulFilter
{
    private static final Logger log = LoggerFactory.getLogger(ErrorFilter.class);

    public String filterType()
    {
        return "error";
    }

    public int filterOrder()
    {
        return 0;
    }

    public boolean shouldFilter()
    {
        return true;
    }

    public Object run()
    {
        try
        {
            RequestContext context = RequestContext.getCurrentContext();
            ZuulException exception = findZuulException(context.getThrowable());
            String body = null;

            if ("Forwarding error".equals(exception.getMessage()))
            {
                Throwable subCause = exception.getCause();
                log.error("zuul进入系统异常拦截", exception);
                if ((subCause instanceof ClientException))
                {
                    String msg = subCause.getMessage();
                    if ((msg != null) &&
                            (subCause.getMessage()
                                    .startsWith("Load balancer does not have available server for client")))
                    {
                        String[] serverNames = msg.split(":");
                        String serverName = serverNames.length > 1 ? serverNames[1] : "";

                        body = JSON.toJSONString(new ErrorResponseData(CommonExceptionEnum.REMOTE_SERVICE_NULL
                                .getCode(), CommonExceptionEnum.REMOTE_SERVICE_NULL
                                .getMessage() + ":" + serverName));
                    }
                }
                else
                {
                    body = JSON.toJSONString(new ErrorResponseData(CommonExceptionEnum.REMOTE_SERVICE_TIMEOUT
                            .getCode(), CommonExceptionEnum.REMOTE_SERVICE_TIMEOUT.getMessage()));
                }

            }
            else
            {
                body = JSON.toJSONString(new ErrorResponseData(CommonExceptionEnum.SYSTEM_ERROR.getCode(), CommonExceptionEnum.SYSTEM_ERROR.getMessage()));
            }
            HttpServletResponse response = context.getResponse();
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().append(body);
            response.flushBuffer();
            return null;
        }
        catch (Throwable e)
        {
            log.error("zuul请求拦截异常未知!", e);
        }return new ErrorResponseData(CommonExceptionEnum.SYSTEM_ERROR.getCode(), CommonExceptionEnum.SYSTEM_ERROR.getMessage());
    }

    private ZuulException findZuulException(Throwable throwable)
    {
        if (ZuulRuntimeException.class.isInstance(throwable.getCause()))
        {
            return (ZuulException)throwable.getCause().getCause();
        }
        if (ZuulException.class.isInstance(throwable.getCause()))
        {
            return (ZuulException)throwable.getCause();
        }

        return ZuulException.class.isInstance(throwable) ? (ZuulException)throwable : new ZuulException(throwable, 500, (String)null);
    }
}