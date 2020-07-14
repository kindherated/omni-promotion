package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityResult;

public interface PromotionActivityResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityResult record);

    int insertSelective(PromotionActivityResult record);

    PromotionActivityResult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityResult record);

    int updateByPrimaryKey(PromotionActivityResult record);
}