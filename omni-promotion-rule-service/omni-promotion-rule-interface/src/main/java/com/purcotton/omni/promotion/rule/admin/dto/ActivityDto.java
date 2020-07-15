package com.purcotton.omni.promotion.rule.admin.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityDto {

    //活动基础信息
    private PromotionActivityDto PromotionActivityDto;

    //促销条件信息
    private List<PromotionActivityConditionDto> conditonList;

    //活动商品信息
    private List<PromotionActivityGoodsDto> goodsList;

    //促销优惠信息
    private List<PromotionActivityResultDto> resultList;

    //促销活动对象信息
    private List<PromotionActivityScopeDto> scopeList;

    //促销门店信息
    private List<PromotionActivityStoreDto> storelist;

}
