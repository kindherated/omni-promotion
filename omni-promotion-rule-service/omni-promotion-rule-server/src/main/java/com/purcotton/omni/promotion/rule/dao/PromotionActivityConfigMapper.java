package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityConfig;

public interface PromotionActivityConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityConfig record);

    int insertSelective(PromotionActivityConfig record);

    PromotionActivityConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityConfig record);

    int updateByPrimaryKey(PromotionActivityConfig record);
}