package com.purcotton.omni.promotion.rule.bean;


import java.util.Date;

public class Rules {

    private Integer id;
    private String rule;
    private String name;
    private Date create_time;
    private Date update_time;
    private Integer visible;
    private String rule_Type;

    public String getRule() {
        return rule;
    }

    public String getRule_Type() {
        return rule_Type;
    }

    public void setRule_Type(String rule_Type) {
        this.rule_Type = rule_Type;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
