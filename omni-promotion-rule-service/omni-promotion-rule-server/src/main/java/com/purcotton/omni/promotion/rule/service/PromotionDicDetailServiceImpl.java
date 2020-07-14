package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionActivityStoreMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionDicDetailMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionDicDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionDicDetailServiceImpl implements PromotionDicDetailService {

    @Resource
    private PromotionDicDetailMapper promotionDicDetailMapper;

    @Override
    public int addPromotionDicDetail(PromotionDicDetail promotionDicDetail) {
        return promotionDicDetailMapper.insertSelective(promotionDicDetail);
    }

    @Override
    public int updatePromotionDicDetail(PromotionDicDetail promotionDicDetail) {
        return promotionDicDetailMapper.updateByPrimaryKeySelective(promotionDicDetail);
    }

    @Override
    public int deletePromotionDicDetailById(Long id) {
        return promotionDicDetailMapper.deleteByPrimaryKey(id);
    }
}
