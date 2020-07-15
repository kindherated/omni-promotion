package com.purcotton.omni.promotion.rule.admin.dto;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionActivityConditionDto implements Serializable {

    //主键ID,非必传
    private Long id;

    //规则序号
    private String seqId;

    //租户id
    private String tenantId;

    //活动ID
    private String activityId;

    //活动类型
    private String activityType;

    //条件类型
    private String conditionType;

    //操作类型
    private String operator;

    //操作值
    private String operatorValue;

}
