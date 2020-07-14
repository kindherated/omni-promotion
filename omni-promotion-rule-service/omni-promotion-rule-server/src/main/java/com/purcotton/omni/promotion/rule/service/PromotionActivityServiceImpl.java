package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityScopeMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityServiceImpl implements  PromotionActivityService {

    @Resource
    private PromotionActivityMapper promotionActivityMapper;

    @Override
    public int addPromotionActivity(PromotionActivity promotionActivity) {
        return promotionActivityMapper.insertSelective(promotionActivity);
    }

    @Override
    public int updatePromotionActivity(PromotionActivity promotionActivity) {
        return promotionActivityMapper.updateByPrimaryKeySelective(promotionActivity);
    }

    @Override
    public int deletePromotionActivityById(Long id) {
        return promotionActivityMapper.deleteByPrimaryKey(id);
    }
}
