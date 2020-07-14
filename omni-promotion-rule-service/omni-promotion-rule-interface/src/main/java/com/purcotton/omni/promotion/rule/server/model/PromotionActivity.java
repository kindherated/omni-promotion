package com.purcotton.omni.promotion.rule.server.model;

import java.util.Date;

public class PromotionActivity {
    private Long id;

    private String tenantId;

    private String activityCode;

    private String activityName;

    private String activityTimeType;

    private Date startTime;

    private Date endTime;

    private String activityCycle;

    private String activityType;

    private String activityStatus;

    private String activityScope;

    private String isRelation;

    private String creator;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode == null ? null : activityCode.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityTimeType() {
        return activityTimeType;
    }

    public void setActivityTimeType(String activityTimeType) {
        this.activityTimeType = activityTimeType == null ? null : activityTimeType.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActivityCycle() {
        return activityCycle;
    }

    public void setActivityCycle(String activityCycle) {
        this.activityCycle = activityCycle == null ? null : activityCycle.trim();
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus == null ? null : activityStatus.trim();
    }

    public String getActivityScope() {
        return activityScope;
    }

    public void setActivityScope(String activityScope) {
        this.activityScope = activityScope == null ? null : activityScope.trim();
    }

    public String getIsRelation() {
        return isRelation;
    }

    public void setIsRelation(String isRelation) {
        this.isRelation = isRelation == null ? null : isRelation.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}