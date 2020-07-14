package com.purcotton.omni.promotion.rule.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 购买商品明细建模
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {

    /** 商品的类别 代码 */
    private String categoryCode;
    /** 商品的类别 名称 */
    private String categoryName;
    // 总金额
    private Double  totalPrice;
    /** 商品编码*/
    private String code;
    /** 购买数量 */
    private Integer quantity;
    /* 零售价格 */
    private BigDecimal retailPrice;
    /* 促销价 */
    private BigDecimal price;
    /* 折扣率 */
    private BigDecimal discount;
    /** 折扣额 */
    private BigDecimal discountAmount;
    // 商品优惠明细
    private List<OrderDiscount> adjustmentList;
}
