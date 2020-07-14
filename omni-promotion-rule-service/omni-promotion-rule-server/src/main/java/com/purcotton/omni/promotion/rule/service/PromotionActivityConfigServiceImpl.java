package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityConditionMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityConfigMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityConfigServiceImpl implements PromotionActivityConfigService {

    @Resource
    private PromotionActivityConfigMapper promotionActivityConfigMapper;


    @Override
    public int addPromotionActivityConfig(PromotionActivityConfig promotionActivityConfig) {
        return promotionActivityConfigMapper.insertSelective(promotionActivityConfig);
    }

    @Override
    public int updatePromotionActivityConfig(PromotionActivityConfig promotionActivityConfig) {
        return promotionActivityConfigMapper.updateByPrimaryKeySelective(promotionActivityConfig);
    }

    @Override
    public int deletePromotionActivityConfigById(Long id) {
        return promotionActivityConfigMapper.deleteByPrimaryKey(id);
    }
}
