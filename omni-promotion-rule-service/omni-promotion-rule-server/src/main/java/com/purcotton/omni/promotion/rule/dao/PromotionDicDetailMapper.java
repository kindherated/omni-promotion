package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionDicDetail;

public interface PromotionDicDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionDicDetail record);

    int insertSelective(PromotionDicDetail record);

    PromotionDicDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionDicDetail record);

    int updateByPrimaryKey(PromotionDicDetail record);
}