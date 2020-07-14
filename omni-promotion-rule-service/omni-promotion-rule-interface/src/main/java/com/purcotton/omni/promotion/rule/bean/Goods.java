package com.purcotton.omni.promotion.rule.bean;

import java.io.Serializable;

public class Goods  implements Serializable {

    private String name;     //商品名称
    private Integer amount;   //购买数量
    private Double discount; //折扣
    private Double price;    //商品单价
    private Double summary;  //总额

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                ", price=" + price +
                ", summary=" + summary +
                '}';
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSummary() {
        return summary;
    }

    public void setSummary(Double summary) {
        this.summary = summary;
    }
}
