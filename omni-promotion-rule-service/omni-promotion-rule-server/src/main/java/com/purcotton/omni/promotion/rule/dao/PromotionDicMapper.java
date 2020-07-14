package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionDic;

public interface PromotionDicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionDic record);

    int insertSelective(PromotionDic record);

    PromotionDic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionDic record);

    int updateByPrimaryKey(PromotionDic record);
}