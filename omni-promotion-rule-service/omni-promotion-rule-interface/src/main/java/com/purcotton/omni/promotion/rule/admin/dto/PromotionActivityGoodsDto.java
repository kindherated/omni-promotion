package com.purcotton.omni.promotion.rule.admin.dto;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionActivityGoodsDto implements Serializable {

    //主键ID
    private Long id;

    //租户ID
    private String tenantId;

    //活动ID
    private Long activityId;

    //商品编码
    private String goodsNo;

    //商品名称
    private String goodsName;


}
