package com.purcotton.omni.promotion.rule.service;

import com.purcotton.omni.promotion.rule.dao.PromotionDicDetailMapper;
import com.purcotton.omni.promotion.rule.dao.PromotionDicMapper;
import com.purcotton.omni.promotion.rule.server.model.PromotionDic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PromotionDicServiceImpl implements PromotionDicService {

    @Resource
    private PromotionDicMapper promotionDicMapper;

    @Override
    public int addPromotionDic(PromotionDic promotionDic) {
        return promotionDicMapper.insertSelective(promotionDic);
    }

    @Override
    public int updatePromotionDic(PromotionDic promotionDic) {
        return promotionDicMapper.updateByPrimaryKeySelective(promotionDic);
    }

    @Override
    public int deletePromotionDicById(Long id) {
        return promotionDicMapper.deleteByPrimaryKey(id);
    }
}
