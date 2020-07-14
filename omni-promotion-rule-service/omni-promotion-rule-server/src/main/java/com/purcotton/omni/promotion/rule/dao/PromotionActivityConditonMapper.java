package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityConditon;

public interface PromotionActivityConditonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityConditon record);

    int insertSelective(PromotionActivityConditon record);

    PromotionActivityConditon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityConditon record);

    int updateByPrimaryKey(PromotionActivityConditon record);
}