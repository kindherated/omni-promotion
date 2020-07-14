package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionActivityStoreMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionActivityStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionActivityStoreServiceImpl implements PromotionActivityStoreService {

    @Resource
    private PromotionActivityStoreMapper promotionActivityStoreMapper;

    @Override
    public int addPromotionActivityStore(PromotionActivityStore promotionActivityStore) {
        return promotionActivityStoreMapper.insertSelective(promotionActivityStore);
    }

    @Override
    public int updatePromotionActivityStore(PromotionActivityStore promotionActivityStore) {
        return promotionActivityStoreMapper.updateByPrimaryKeySelective(promotionActivityStore);
    }

    @Override
    public int deletePromotionActivityStoreById(Long id) {
        return promotionActivityStoreMapper.deleteByPrimaryKey(id);
    }
}
