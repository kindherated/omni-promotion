package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivity;

public interface PromotionActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivity record);

    int insertSelective(PromotionActivity record);

    PromotionActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivity record);

    int updateByPrimaryKey(PromotionActivity record);
}