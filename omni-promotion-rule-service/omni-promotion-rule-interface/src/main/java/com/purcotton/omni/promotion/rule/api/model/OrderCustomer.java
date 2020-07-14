package com.purcotton.omni.promotion.rule.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 会员信息建模
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCustomer implements Serializable {

    //会员ID
    private String customerId;

    //会员编码
    private String customerCode;

    //会员等级
    private String customerLevel;

    //会员标签
    private List<String> customerTags;

}
