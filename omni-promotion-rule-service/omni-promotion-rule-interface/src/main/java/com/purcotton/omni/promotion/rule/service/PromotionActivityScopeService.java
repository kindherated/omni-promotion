package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityScope;

public interface PromotionActivityScopeService {

    public int addPromotionActivityScope(PromotionActivityScope promotionActivityScope);

    public int updatePromotionActivityScope(PromotionActivityScope promotionActivityScope);

    public int deletePromotionActivityScopeById(Long id);
}
