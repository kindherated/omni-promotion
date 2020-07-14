package com.purcotton.omni.promotion.rule.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Score {

    private int age;

    private int gender;

    private int zmScore;

    private int score = 0;

}
