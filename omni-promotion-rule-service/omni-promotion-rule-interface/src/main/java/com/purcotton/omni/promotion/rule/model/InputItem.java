package com.purcotton.omni.promotion.rule.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品模型
 */
@Data
public class InputItem {

    public InputItem(String code) {
        this.code = code;
    }

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

    /** 品牌代码 */
    private  String brandNo;

}
