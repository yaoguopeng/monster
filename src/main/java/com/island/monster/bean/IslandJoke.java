package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛开心一刻
 */
public class IslandJoke implements Serializable {

    private static final long serialVersionUID = 4138013873786250224L;
    private Integer id; // 主键
    private String content;
    private String imagePath;
    private String uuid; // 笑话唯一标识
    private Date createdTime;
    @JsonIgnore
    private Integer isDeleted;

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "IslandJoke{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", uuid='" + uuid + '\'' +
                ", createdTime=" + createdTime +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
