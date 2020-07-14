package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityRule;

public interface PromotionActivityRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityRule record);

    int insertSelective(PromotionActivityRule record);

    PromotionActivityRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityRule record);

    int updateByPrimaryKeyWithBLOBs(PromotionActivityRule record);

    int updateByPrimaryKey(PromotionActivityRule record);
}