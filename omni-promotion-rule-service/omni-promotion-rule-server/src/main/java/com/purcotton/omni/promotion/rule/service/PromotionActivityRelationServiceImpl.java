package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityLogMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityRelationMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityRelation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityRelationServiceImpl implements PromotionActivityRelationService {

    @Resource
    private PromotionActivityRelationMapper promotionActivityRelationMapper;

    @Override
    public int addPromotionActivityRelation(PromotionActivityRelation promotionActivityRelation) {
        return promotionActivityRelationMapper.insertSelective(promotionActivityRelation);
    }

    @Override
    public int updatePromotionActivityRelation(PromotionActivityRelation promotionActivityRelation) {
        return promotionActivityRelationMapper.updateByPrimaryKeySelective(promotionActivityRelation);
    }

    @Override
    public int deletePromotionActivityRelationById(Long id) {
        return promotionActivityRelationMapper.deleteByPrimaryKey(id);
    }
}
