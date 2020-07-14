package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.exception.JsonResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("RULE-ENGINE-SERVICE")
public interface RuleServiceFeign {

    @GetMapping(value = "/test/test1")
    public JsonResponse test1();

}
