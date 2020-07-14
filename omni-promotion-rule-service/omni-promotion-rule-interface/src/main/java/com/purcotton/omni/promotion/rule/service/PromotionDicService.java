package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionDic;

public interface PromotionDicService {

    public int addPromotionDic(PromotionDic promotionDic);

    public int updatePromotionDic(PromotionDic promotionDic);

    public int deletePromotionDicById(Long id);
}
