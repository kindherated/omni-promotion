package com.purcotton.omni.promotion.rule.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Input implements Serializable {
    //商品列表信息
    private List<InputItem> inputList;

    public Input() {
        this.inputList = new ArrayList<>();
    }

}
