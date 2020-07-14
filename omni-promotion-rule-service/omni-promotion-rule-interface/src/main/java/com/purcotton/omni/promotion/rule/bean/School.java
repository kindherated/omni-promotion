package com.purcotton.omni.promotion.rule.bean;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class School implements Serializable {

    private String name;
    private String className;
    private List<Student> classNameList;

    public School(String name, String className) {
        this.name = name;
        this.className = className;
    }
}
