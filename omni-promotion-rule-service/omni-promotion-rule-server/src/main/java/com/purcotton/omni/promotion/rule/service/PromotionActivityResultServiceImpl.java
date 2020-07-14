package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityRelationMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityResultMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityResultServiceImpl implements  PromotionActivityResultService {

    @Resource
    private PromotionActivityResultMapper promotionActivityResultMapper;

    @Override
    public int addPromotionActivityResult(PromotionActivityResult promotionActivityResult) {
        return promotionActivityResultMapper.updateByPrimaryKeySelective(promotionActivityResult);
    }

    @Override
    public int updatePromotionActivityResult(PromotionActivityResult promotionActivityResult) {
        return promotionActivityResultMapper.updateByPrimaryKeySelective(promotionActivityResult);
    }

    @Override
    public int deletePromotionActivityResultById(Long id) {
        return promotionActivityResultMapper.deleteByPrimaryKey(id);
    }
}
