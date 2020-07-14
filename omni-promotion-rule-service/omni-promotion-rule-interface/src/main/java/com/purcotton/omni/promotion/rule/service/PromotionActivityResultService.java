package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityResult;

public interface PromotionActivityResultService {
    
    public int addPromotionActivityResult(PromotionActivityResult promotionActivityResult);

    public int updatePromotionActivityResult(PromotionActivityResult promotionActivityResult);

    public int deletePromotionActivityResultById(Long id);
}
