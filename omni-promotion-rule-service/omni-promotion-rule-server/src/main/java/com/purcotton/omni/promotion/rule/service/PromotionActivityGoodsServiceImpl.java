package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityConfigMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityGoodsMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityGoodsServiceImpl implements PromotionActivityGoodsService {

    @Resource
    private PromotionActivityGoodsMapper promotionActivityGoodsMapper;


    @Override
    public int addPromotionActivityGoods(PromotionActivityGoods promotionActivityGoods) {
        return promotionActivityGoodsMapper.insertSelective(promotionActivityGoods);
    }

    @Override
    public int updatePromotionActivityGoods(PromotionActivityGoods promotionActivityGoods) {
        return promotionActivityGoodsMapper.updateByPrimaryKeySelective(promotionActivityGoods);
    }

    @Override
    public int deletePromotionActivityGoodsById(Long id) {
        return promotionActivityGoodsMapper.deleteByPrimaryKey(id);
    }
}
