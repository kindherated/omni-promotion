package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityRuleMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityScopeMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityScopeServiceImpl implements  PromotionActivityScopeService {

    @Resource
    private PromotionActivityScopeMapper promotionActivityScopeMapper;

    @Override
    public int addPromotionActivityScope(PromotionActivityScope promotionActivityScope) {
        return promotionActivityScopeMapper.insertSelective(promotionActivityScope);
    }

    @Override
    public int updatePromotionActivityScope(PromotionActivityScope promotionActivityScope) {
        return promotionActivityScopeMapper.updateByPrimaryKeySelective(promotionActivityScope);
    }

    @Override
    public int deletePromotionActivityScopeById(Long id) {
        return promotionActivityScopeMapper.deleteByPrimaryKey(id);
    }
}
