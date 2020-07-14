package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityStore;

public interface PromotionActivityStoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityStore record);

    int insertSelective(PromotionActivityStore record);

    PromotionActivityStore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityStore record);

    int updateByPrimaryKey(PromotionActivityStore record);
}