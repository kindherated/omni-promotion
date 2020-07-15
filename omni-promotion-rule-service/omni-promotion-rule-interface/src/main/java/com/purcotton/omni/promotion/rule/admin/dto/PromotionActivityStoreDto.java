package com.purcotton.omni.promotion.rule.admin.dto;
import lombok.Data;
import java.io.Serializable;

@Data
public class PromotionActivityStoreDto implements Serializable {

    //主键ID
    private Long id;

    //租户ID
    private String tenantId;

    //活动Id
    private Long activityId;

    //门店类型(0-白名单;1-黑名单)
    private String storeType;

    //门店编码
    private String storeNo;

    //门店名称
    private String storeName;

    //门店所属区域
    private String storeZone;

}
