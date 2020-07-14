package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityRelation;

public interface PromotionActivityRelationService {

    public int addPromotionActivityRelation(PromotionActivityRelation promotionActivityRelation);

    public int updatePromotionActivityRelation(PromotionActivityRelation promotionActivityRelation);

    public int deletePromotionActivityRelationById(Long id);
}
