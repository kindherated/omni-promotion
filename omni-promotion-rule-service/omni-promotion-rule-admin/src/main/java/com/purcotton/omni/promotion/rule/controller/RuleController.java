package com.purcotton.omni.promotion.rule.controller;

import com.purcotton.omni.promotion.rule.exception.JsonResponse;
import com.purcotton.omni.promotion.rule.service.RuleServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleController {

    @Autowired
    private RuleServiceFeign ruleServiceFeign;

    @GetMapping("/rule/test")
    public JsonResponse test1(){
        return ruleServiceFeign.test1();
    }
}
