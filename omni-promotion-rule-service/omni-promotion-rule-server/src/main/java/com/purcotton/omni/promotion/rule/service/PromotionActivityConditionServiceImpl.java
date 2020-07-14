package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityConditionMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityConditionServiceImpl implements PromotionActivityConditionService {

    @Resource
    private PromotionActivityConditionMapper promotionActivityConditionMapper;

    @Override
    public int addPromotionActivityCondition(PromotionActivityCondition promotionActivityCondition) {
        return promotionActivityConditionMapper.insertSelective(promotionActivityCondition);
    }

    @Override
    public int updatePromotionActivityCondition(PromotionActivityCondition promotionActivityCondition) {
        return promotionActivityConditionMapper.updateByPrimaryKeySelective(promotionActivityCondition);
    }

    @Override
    public int deletePromotionActivityConditionById(Long id) {
        return  promotionActivityConditionMapper.deleteByPrimaryKey(id);
    }
}
