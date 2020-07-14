package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCategory;

public interface PromotionActivityCategoryService {

    public int addPromotionActivityCategory(PromotionActivityCategory promotionActivityCategory);

    public int updatePromotionActivityCategory(PromotionActivityCategory promotionActivityCategory);

    public int deletePromotionActivityCategoryById(Long id);

}
