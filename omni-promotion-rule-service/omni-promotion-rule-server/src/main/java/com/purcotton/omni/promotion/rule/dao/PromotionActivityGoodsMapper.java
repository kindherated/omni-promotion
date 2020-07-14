package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityGoods;

public interface PromotionActivityGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityGoods record);

    int insertSelective(PromotionActivityGoods record);

    PromotionActivityGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityGoods record);

    int updateByPrimaryKey(PromotionActivityGoods record);
}