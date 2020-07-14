package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityScope;

public interface PromotionActivityScopeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityScope record);

    int insertSelective(PromotionActivityScope record);

    PromotionActivityScope selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityScope record);

    int updateByPrimaryKey(PromotionActivityScope record);
}