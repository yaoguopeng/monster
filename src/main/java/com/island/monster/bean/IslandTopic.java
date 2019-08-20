package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛主题信息
 */
public class IslandTopic implements Serializable {

    private static final long serialVersionUID = -320982472780968591L;
    private String id;
    private String topicName;
    private String topicType;
    private String createdBy;
    private Date createdTime;
    @JsonIgnore
    private Integer isDeleted;
    private Integer auditStatus;

    private Long topicVisitTimes;
    private Long postAmounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getTopicVisitTimes() {
        return topicVisitTimes;
    }

    public void setTopicVisitTimes(Long topicVisitTimes) {
        this.topicVisitTimes = topicVisitTimes;
    }

    public Long getPostAmounts() {
        return postAmounts;
    }

    public void setPostAmounts(Long postAmounts) {
        this.postAmounts = postAmounts;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }
}
