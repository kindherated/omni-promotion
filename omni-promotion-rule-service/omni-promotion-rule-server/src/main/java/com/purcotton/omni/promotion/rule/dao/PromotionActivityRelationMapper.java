package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityRelation;

public interface PromotionActivityRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityRelation record);

    int insertSelective(PromotionActivityRelation record);

    PromotionActivityRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityRelation record);

    int updateByPrimaryKey(PromotionActivityRelation record);
}