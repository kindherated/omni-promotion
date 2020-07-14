package com.purcotton.omni.promotion.rule.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private String name; //姓名
    private Integer age; //年龄
    private String stuNo;  //学号
    private String className; //班级
    private School school; //学校
}
