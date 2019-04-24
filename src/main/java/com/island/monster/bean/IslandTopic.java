package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.island.monster.common.IslandCommon.TopicType;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛主题信息
 */
public class IslandTopic implements Serializable {

    private static final long serialVersionUID = -320982472780968591L;
    private String id;
    private String topicName;
    private TopicType topicType;
    private String createdBy;
    private Date createdTime;
    @JsonIgnore
    private String isDeleted;
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

    public TopicType getTopicType() {
        return topicType;
    }

    public void setTopicType(TopicType topicType) {
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

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
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

    @Override
    public String toString() {
        return "IslandTopic{" +
                "id='" + id + '\'' +
                ", topicName='" + topicName + '\'' +
                ", topicType=" + topicType +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", isDeleted='" + isDeleted + '\'' +
                ", topicVisitTimes=" + topicVisitTimes +
                ", postAmounts=" + postAmounts +
                '}';
    }
}
