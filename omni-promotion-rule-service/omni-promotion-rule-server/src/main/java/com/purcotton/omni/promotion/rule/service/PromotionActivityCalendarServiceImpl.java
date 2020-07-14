package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityCalendarMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCalendar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityCalendarServiceImpl implements PromotionActivityCalendarService {

    @Resource
    private PromotionActivityCalendarMapper promotionActivityCalendarMapper;

    @Override
    public int addPromotionActivityCalendar(PromotionActivityCalendar promotionActivityCalendar) {
        return promotionActivityCalendarMapper.insertSelective(promotionActivityCalendar);
    }

    @Override
    public int updatePromotionActivityCalendar(PromotionActivityCalendar promotionActivityCalendar) {
        return promotionActivityCalendarMapper.updateByPrimaryKeySelective(promotionActivityCalendar);
    }

    @Override
    public int deletePromotionActivityCalendarById(Long id) {
        return promotionActivityCalendarMapper.deleteByPrimaryKey(id);
    }
}
