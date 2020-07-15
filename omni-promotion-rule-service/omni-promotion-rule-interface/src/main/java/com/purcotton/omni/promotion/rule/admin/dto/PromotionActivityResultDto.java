package com.purcotton.omni.promotion.rule.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionActivityResultDto implements Serializable {

    //主键ID
    private Long id;

    //条件序号ID
    private String seqId;

    //租户ID
    private String tenantId;

    //活动ID
    private Long activityId;

    //条件类型
    private String conditionType;

    //扣减金额
    private String operatorValue;
}
