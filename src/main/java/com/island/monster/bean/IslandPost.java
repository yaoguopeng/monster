package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛帖子信息
 */
public class IslandPost implements Serializable {

    private static final long serialVersionUID = 341183815282529974L;
    private String id;
    private String topicId;
    private String postContent;
    private String postImagePath;
    private String createdBy;
    private Date createdTime;
    private Date updatedTime;
    private Integer replyAmounts; // 回复数量
    private Integer thumbsUpAmounts; // 点赞数量
    private Integer postVisitedTimes; // 帖子访客量
    @JsonIgnore
    private String isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostImagePath() {
        return postImagePath;
    }

    public void setPostImagePath(String postImagePath) {
        this.postImagePath = postImagePath;
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

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getReplyAmounts() {
        return replyAmounts;
    }

    public void setReplyAmounts(Integer replyAmounts) {
        this.replyAmounts = replyAmounts;
    }

    public Integer getThumbsUpAmounts() {
        return thumbsUpAmounts;
    }

    public void setThumbsUpAmounts(Integer thumbsUpAmounts) {
        this.thumbsUpAmounts = thumbsUpAmounts;
    }

    public Integer getPostVisitedTimes() {
        return postVisitedTimes;
    }

    public void setPostVisitedTimes(Integer postVisitedTimes) {
        this.postVisitedTimes = postVisitedTimes;
    }
}
