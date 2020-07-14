package com.purcotton.omni.promotion.rule.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 订单结算明细建模
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    // 总金额
    private Double paidPrice;
    // 商品总个数
    private  int quantity;
    // 门店编码
    private String storeNo;
    // 会员信息
    private OrderCustomer orderCustomer;
    // 订单中包含的单个产品列表
    private List<OrderItem> itemList;
}
