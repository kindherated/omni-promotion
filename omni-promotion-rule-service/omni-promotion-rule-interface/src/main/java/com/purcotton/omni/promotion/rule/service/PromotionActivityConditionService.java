package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCondition;

public interface PromotionActivityConditionService {

    public int addPromotionActivityCondition(PromotionActivityCondition promotionActivityCondition);

    public int updatePromotionActivityCondition(PromotionActivityCondition promotionActivityCondition);

    public int deletePromotionActivityConditionById(Long id);
}
