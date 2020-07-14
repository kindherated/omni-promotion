package com.purcotton.omni.promotion.rule.controller;
import com.purcotton.omni.promotion.exception.JsonResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@RestController()
@Slf4j
public class TestRuleController {

    @Autowired
    private KieHelper kieHelper;

    @Autowired
    private KieSession kieSession;

    @Autowired
    private RedissonClient redissonClient;

    @ApiOperation(value = "验证kieHelper")
    @GetMapping(value = "/test/test1", produces = "application/json;charset=UTF-8")
    public JsonResponse test1() {
        Instant start = Instant.now();
        String format = "yyyy-MM-dd"; //"dd-MM-yyyy"
        System.setProperty("drools.dateformat", format); //指定日期格式，不然会出现日期转换报错
        //加载drl文件到规则库
        kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/date.drl"), ResourceType.DRL);
        //创建会话
        KieSession kieSession = kieHelper.build().newKieSession();
        //执行规则
        int count = kieSession.fireAllRules();
        System.out.println("总共有count："+count+"条规则被匹配");
        //清理session状态,释放资源
        kieSession.dispose();
        Instant end = Instant.now();
        log.info("程序耗时{}", Duration.between(start,end).toMillis());
        return new JsonResponse(count);
    }


    @ApiOperation(value = "验证kieHelper")
    @GetMapping(value = "/test2", produces = "application/json;charset=UTF-8")
    public JsonResponse test2() {
        String format = "yyyy-MM-dd"; //"dd-MM-yyyy"
        System.setProperty("drools.dateformat", format); //指定日期格式，不然会出现日期转换报错
        //加载drl文件到规则库
        kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/date.drl"), ResourceType.DRL);
        //创建会话
        KieSession kieSession = kieHelper.build().newKieSession();
        //执行规则
        int count = kieSession.fireAllRules();
        System.out.println("总共有count："+count+"条规则被匹配");
        //清理session状态,释放资源
        kieSession.dispose();
        RBucket<String> hello = redissonClient.getBucket("hello");
        System.out.println(hello.get());
        if(!StringUtils.isNoneBlank(hello.get())){
            hello.set("world",60, TimeUnit.MINUTES);
        }
        return new JsonResponse(count);
    }
}
