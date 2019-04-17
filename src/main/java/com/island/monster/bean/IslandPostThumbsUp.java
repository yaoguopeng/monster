package com.island.monster.bean;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛点赞帖子
 */
public class IslandPostThumbsUp implements Serializable {

    private static final long serialVersionUID = 7859552965820422387L;
    private String id;
    @NotEmpty(message = "postId can not be empty")
    private String postId; // 被赞帖子id
    @NotEmpty(message = "unionId can not be empty")
    private String thumbsUpBy; //点赞者unionId
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

    public String getThumbsUpBy() {
        return thumbsUpBy;
    }

    public void setThumbsUpBy(String thumbsUpBy) {
        this.thumbsUpBy = thumbsUpBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
