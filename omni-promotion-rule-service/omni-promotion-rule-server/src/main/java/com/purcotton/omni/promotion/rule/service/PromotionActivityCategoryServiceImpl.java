package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityCategoryMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityCategoryServiceImpl implements PromotionActivityCategoryService {

    @Resource
    private PromotionActivityCategoryMapper promotionActivityCategoryMapper;

    @Override
    public int addPromotionActivityCategory(PromotionActivityCategory promotionActivityCategory) {
        return promotionActivityCategoryMapper.insertSelective(promotionActivityCategory);
    }

    @Override
    public int updatePromotionActivityCategory(PromotionActivityCategory promotionActivityCategory) {
        return promotionActivityCategoryMapper.updateByPrimaryKeySelective(promotionActivityCategory);
    }

    @Override
    public int deletePromotionActivityCategoryById(Long id) {
        return promotionActivityCategoryMapper.deleteByPrimaryKey(id);
    }
}
