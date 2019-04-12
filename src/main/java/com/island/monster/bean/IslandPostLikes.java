package com.island.monster.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛点赞帖子
 */
public class IslandPostLikes implements Serializable {

    private static final long serialVersionUID = 7859552965820422387L;
    private String id;
    private String postId; // 被赞帖子id
    private String likeUserId; //点赞者unionid
    private Date createdTime;

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

    public String getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(String likeUserId) {
        this.likeUserId = likeUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
