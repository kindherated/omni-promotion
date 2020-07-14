package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityRule;

public interface PromotionActivityRuleService {

    public int addPromotionActivityRule(PromotionActivityRule promotionActivityRule);

    public int updatePromotionActivityRule(PromotionActivityRule promotionActivityRule);

    public int deletePromotionActivityRuleById(Long id);
}
