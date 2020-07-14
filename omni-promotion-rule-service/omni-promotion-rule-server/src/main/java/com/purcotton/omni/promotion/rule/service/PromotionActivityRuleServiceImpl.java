package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityResultMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityRuleMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityRuleServiceImpl implements  PromotionActivityRuleService {

    @Resource
    private PromotionActivityRuleMapper promotionActivityRuleMapper;

    @Override
    public int addPromotionActivityRule(PromotionActivityRule promotionActivityRule) {
        return promotionActivityRuleMapper.insertSelective(promotionActivityRule);
    }

    @Override
    public int updatePromotionActivityRule(PromotionActivityRule promotionActivityRule) {
        return promotionActivityRuleMapper.updateByPrimaryKeySelective(promotionActivityRule);
    }

    @Override
    public int deletePromotionActivityRuleById(Long id) {
        return promotionActivityRuleMapper.deleteByPrimaryKey(id);
    }
}
