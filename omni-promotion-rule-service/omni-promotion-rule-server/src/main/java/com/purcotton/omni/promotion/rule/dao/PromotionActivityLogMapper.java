package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityLog;

public interface PromotionActivityLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityLog record);

    int insertSelective(PromotionActivityLog record);

    PromotionActivityLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityLog record);

    int updateByPrimaryKey(PromotionActivityLog record);
}