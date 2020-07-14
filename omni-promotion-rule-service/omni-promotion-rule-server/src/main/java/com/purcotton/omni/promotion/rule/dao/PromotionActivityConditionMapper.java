package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCondition;

public interface PromotionActivityConditionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityCondition record);

    int insertSelective(PromotionActivityCondition record);

    PromotionActivityCondition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityCondition record);

    int updateByPrimaryKey(PromotionActivityCondition record);
}