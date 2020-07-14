package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityGoods;

public interface PromotionActivityGoodsService {

    public int addPromotionActivityGoods(PromotionActivityGoods promotionActivityGoods);

    public int updatePromotionActivityGoods(PromotionActivityGoods promotionActivityGoods);

    public int deletePromotionActivityGoodsById(Long id);
}
