package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityConfig;

public interface PromotionActivityConfigService {

    public int addPromotionActivityConfig(PromotionActivityConfig promotionActivityConfig);

    public int updatePromotionActivityConfig(PromotionActivityConfig promotionActivityConfig);

    public int deletePromotionActivityConfigById(Long id);
}
