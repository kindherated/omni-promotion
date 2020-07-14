package com.purcotton.omni.promotion.rule.api.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

/**
 * 商品优惠明细建模
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDiscount implements Serializable {

    /** 商品编码*/
    private String code;
    // 优惠类型
    private  int type;
    //优惠金额
    private  double discount;
    // 优惠百分比，可能一个优惠卷分摊到多个订单条目上面
    private  double percent;
    // 优惠券 规则名称
    private  String ruleName;
    //活动编码
    private String activityNo;
    //活动名称
    private String activityName;

}
