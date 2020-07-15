package com.purcotton.omni.promotion.rule.admin.dto;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionActivityDto implements Serializable {

    //促销活动ID
    private Long id;

    //租户id
    private String tenantId;

    //活动编码
    private String activityCode;

    //活动名称
    private String activityName;

    //活动时间类型 0-固定 1-周期
    private String activityTimeType;

    //活动开始时间
    private Date startTime;

    //活动结束时间
    private Date endTime;

    //活动周期
    private String activityCycle;

    //活动类型
    private String activityType;

    //活动商品类型(0-按sku设置;1按品类设置)
    private String activityScope;

}
