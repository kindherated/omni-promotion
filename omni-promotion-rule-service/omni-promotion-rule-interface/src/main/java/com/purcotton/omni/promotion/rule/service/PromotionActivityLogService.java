package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityLog;

public interface PromotionActivityLogService {

    public int addPromotionActivityLog(PromotionActivityLog promotionActivityLog);

    public int updatePromotionActivityLog(PromotionActivityLog promotionActivityLog);

    public int deletePromotionActivityLogById(Long id);
}
