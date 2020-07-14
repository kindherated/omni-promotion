package com.purcotton.omni.promotion.rule.dao;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCalendar;

public interface PromotionActivityCalendarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionActivityCalendar record);

    int insertSelective(PromotionActivityCalendar record);

    PromotionActivityCalendar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionActivityCalendar record);

    int updateByPrimaryKey(PromotionActivityCalendar record);
}