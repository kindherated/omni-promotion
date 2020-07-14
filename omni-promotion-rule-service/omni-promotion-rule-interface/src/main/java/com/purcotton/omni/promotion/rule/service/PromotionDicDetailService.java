package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionDicDetail;

public interface PromotionDicDetailService {

    public int addPromotionDicDetail(PromotionDicDetail promotionDicDetail);

    public int updatePromotionDicDetail(PromotionDicDetail promotionDicDetail);

    public int deletePromotionDicDetailById(Long id);
    
}
