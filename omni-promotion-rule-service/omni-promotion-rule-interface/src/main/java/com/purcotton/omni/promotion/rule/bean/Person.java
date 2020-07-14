package com.purcotton.omni.promotion.rule.bean;


import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer age;

    private String name;

    private String desc;

    private String sex;

    private List<String> hobbies;

    private Map<String,Object> testMap;

    private Set<String> testSet;

    public Map<String, Object> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<String, Object> testMap) {
        this.testMap = testMap;
    }

    public Set<String> getTestSet() {
        return testSet;
    }

    public void setTestSet(Set<String> testSet) {
        this.testSet = testSet;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Integer age, String name, String desc) {
        this.age = age;
        this.name = name;
        this.desc = desc;
    }


    public Person(Integer age, String name, String desc, String sex) {
        this.age = age;
        this.name = name;
        this.desc = desc;
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", sex='" + sex + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
