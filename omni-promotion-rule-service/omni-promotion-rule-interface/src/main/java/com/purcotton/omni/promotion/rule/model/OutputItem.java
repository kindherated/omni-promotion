package com.purcotton.omni.promotion.rule.model;
import lombok.Data;
import java.io.Serializable;

@Data
public class OutputItem implements Serializable {
    /** 代码 */
    private String code;

    /** 购买数量 */
    private int quantity;

    /** 名称 */
    private String name;

    /** 零售价 */
    private Double retailPrice;

    /** 促销价 */
    private double price;

    /** 折扣率 */
    private double discount;

    /** 折扣额 */
    private double amount;

    /** 单一商品的分摊优惠值 */
    private double singleTotalProm;

    /** 商品的品牌 代码 */
    private String brandCode;

    /** 商品的品牌名称 */
    private String brandName;

    /** 商品的类别 代码 */
    private String categoryCode;

    /** 商品的类别 名称 */
    private String categoryName;

    /** 赠品是否需加价购买 */
    private boolean giftsAskMoney = false;
    /** 购买组数量,数量条件=于的情况 */
    private int giftAndNumber;
    private int giftORNumber;
    private int giftsNumber;
    /** 赠品特价购买 */
    private double giftsPrice;
    private double giftsDiscount;
    private double giftsAmount;
    /** 特价购买时最大购买组数量,若规则中不设置,默为为 1 */
    private int giftAndMaxNumber = 1;
    private int giftORMaxNumber = 1;
    private int giftsMaxNumber = 1;
    /** 赠品是否需要手工输入 */
    private boolean needInput;

    /** 赠品并输出 */
    //private GroupAnd giftAndType;
    /** 赠品或输出 */
    //private GroupOr giftOrType;
    /** 赠品组输出 */
    //private Groups giftGroupType;
    /** 赠品组形式:并或组 */
    //private GiftForm gForm;
    /** 赠品价格形式 */
    //private GiftsPromPriceForm gPriceForm;

}
