package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCalendar;

public interface PromotionActivityCalendarService {

    public int addPromotionActivityCalendar(PromotionActivityCalendar promotionActivityCalendar);

    public int updatePromotionActivityCalendar(PromotionActivityCalendar promotionActivityCalendar);

    public int deletePromotionActivityCalendarById(Long id);
}
