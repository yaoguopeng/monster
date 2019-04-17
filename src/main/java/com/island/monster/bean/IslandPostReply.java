package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛帖子回复信息
 */
public class IslandPostReply implements Serializable {

    private static final long serialVersionUID = -7243854244778492588L;
    private String id;
    @NotEmpty(message = "postId can not be empty")
    private String postId;
    private String replyId;
    @NotEmpty(message = "replyContent can not be empty")
    private String replyContent;
    @NotEmpty(message = "replyFrom unionId can not be empty")
    private String replyFrom;
    @NotEmpty(message = "replyTo unionId can not be empty")
    private String replyTo;
    private Date createdTime;
    private Date updatedTime;
    @JsonIgnore
    private String isDeleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyFrom() {
        return replyFrom;
    }

    public void setReplyFrom(String replyFrom) {
        this.replyFrom = replyFrom;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
