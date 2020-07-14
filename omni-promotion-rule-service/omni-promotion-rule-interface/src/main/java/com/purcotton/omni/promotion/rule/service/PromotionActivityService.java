package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivity;

public interface PromotionActivityService {

    public int addPromotionActivity(PromotionActivity promotionActivity);

    public int updatePromotionActivity(PromotionActivity promotionActivity);

    public int deletePromotionActivityById(Long id);

}
