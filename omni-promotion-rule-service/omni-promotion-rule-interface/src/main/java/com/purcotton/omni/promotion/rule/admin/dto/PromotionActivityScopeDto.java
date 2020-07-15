package com.purcotton.omni.promotion.rule.admin.dto;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionActivityScopeDto implements Serializable {

    //主键ID
    private Long id;

    //租户ID
    private String tenantId;

    //活动对象序号
    private String seqId;

    //活动Id
    private Long activityId;

    //对象类型(0-全部会员1-会员等级;2-会员标签;3-指定会员)
    private String scopeType;

    //活动对象 黑名单/白名单
    private String activityObj;

    //用户标签
    private String userTag;

    //指定会员账号
    private String customerNo;

    //会员等级
    private String levelNo;

}
