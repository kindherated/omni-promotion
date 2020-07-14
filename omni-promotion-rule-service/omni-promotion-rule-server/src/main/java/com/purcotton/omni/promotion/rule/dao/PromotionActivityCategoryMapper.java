package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCategory;

public interface PromotionActivityCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityCategory record);

    int insertSelective(PromotionActivityCategory record);

    PromotionActivityCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityCategory record);

    int updateByPrimaryKey(PromotionActivityCategory record);
}