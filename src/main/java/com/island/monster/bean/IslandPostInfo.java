package com.island.monster.bean;

import java.io.Serializable;

/**
 * 时光小岛帖子信息
 */
public class IslandPostInfo implements Serializable {

    private static final long serialVersionUID = -9151416791670986065L;
    private String postId;
    private Integer postVisitTimes;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Integer getPostVisitTimes() {
        return postVisitTimes;
    }

    public void setPostVisitTimes(Integer postVisitTimes) {
        this.postVisitTimes = postVisitTimes;
    }

    @Override
    public String toString() {
        return "IslandPostInfo{" +
                "postId='" + postId + '\'' +
                ", postVisitTimes=" + postVisitTimes +
                '}';
    }
}
