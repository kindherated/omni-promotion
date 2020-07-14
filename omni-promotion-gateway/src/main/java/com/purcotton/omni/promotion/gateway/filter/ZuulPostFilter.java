package com.purcotton.omni.promotion.gateway.filter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aliyun.oss.common.utils.IOUtils;
import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.purcotton.omni.common.exception.CommonException;
import com.purcotton.omni.common.exception.CommonExceptionEnum;
import com.purcotton.omni.common.response.SuccessResponseData;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ZuulPostFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(ZuulPostFilter.class);
    private static final String CONTENT_TYPE = "Content-Type";
    private static final SerializerFeature[] SERIALIZER_FEATURE = {SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty};

    public String filterType() {
        return "post";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();

        if (HttpStatus.NOT_FOUND.value() == currentContext.getResponseStatusCode()) {
            log.error("404找不到服务...");

            currentContext.setResponseBody(JSON.toJSONString(SuccessResponseData.error(CommonExceptionEnum.NO_FOUNT.getCode(), CommonExceptionEnum.NO_FOUNT.getMessage())));
            return null;
        }
        if (HttpStatus.INTERNAL_SERVER_ERROR.value() == currentContext.getResponseStatusCode()) {
            log.error("500服务内部错误...");

            return null;
        }
        if (HttpStatus.OK.value() != currentContext.getResponseStatusCode()) {
            log.error("请求失败");

            return null;
        }

        try {
            parseObject();
        } catch (IOException e) {
            log.error("zuul读取返回值错误", e);
            throw new CommonException(CommonExceptionEnum.SERVICE_ERROR);
        }

        return null;
    }

    private void parseObject() throws IOException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        String contentType = "";
        List<Pair<String, String>> originResponseHeaders = currentContext.getOriginResponseHeaders();
        for (Pair originResponseHeader : originResponseHeaders) {
            if ("Content-Type".equals(originResponseHeader.first())) {
                contentType = (String) originResponseHeader.second();
            }
        }
        String responseBody = currentContext.getResponseBody();

        if (((StringUtils.isBlank(contentType)) || (StringUtils.contains(contentType, "application/json"))) && (responseBody == null) &&
                (currentContext
                        .getResponseDataStream() != null)) {
            String s = IOUtils.readStreamAsString(currentContext.getResponseDataStream(), "utf-8");
            try {
                Object o = JSON.parse(s);
                if ((o instanceof JSONObject)) {
                    JSONObject json = (JSONObject) o;
                    if (isErrorData(json)) {
                        currentContext.setResponseBody(json.toJSONString());
                        return;
                    }

                }

                currentContext.setResponseBody(JSON.toJSONString(SuccessResponseData.success(o), SERIALIZER_FEATURE));
            } catch (JSONException e) {
                log.error("zuul JSON解析返回值错误", e);

                currentContext.setResponseBody(JSON.toJSONString(SuccessResponseData.success(responseBody)));
            }
        }
    }

    private boolean isErrorData(JSONObject json) {
        return (json.containsKey("code")) && (json.containsKey("message")) &&
                (json
                        .containsKey("success")) &&
                (json.containsKey("data"));
    }
}