package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityGoodsMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityLogMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityLogServiceImpl implements  PromotionActivityLogService {

    @Resource
    private PromotionActivityLogMapper promotionActivityLogMapper;

    @Override
    public int addPromotionActivityLog(PromotionActivityLog promotionActivityLog) {
        return promotionActivityLogMapper.insertSelective(promotionActivityLog);
    }

    @Override
    public int updatePromotionActivityLog(PromotionActivityLog promotionActivityLog) {
        return promotionActivityLogMapper.updateByPrimaryKeySelective(promotionActivityLog);
    }

    @Override
    public int deletePromotionActivityLogById(Long id) {
        return promotionActivityLogMapper.deleteByPrimaryKey(id);
    }
}
