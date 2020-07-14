package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityStore;

public interface PromotionActivityStoreService {

    public int addPromotionActivityStore(PromotionActivityStore promotionActivityStore);

    public int updatePromotionActivityStore(PromotionActivityStore promotionActivityStore);

    public int deletePromotionActivityStoreById(Long id);
}
