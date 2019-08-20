package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛画廊
 */
public class IslandPainting implements Serializable {

    private static final long serialVersionUID = -2418566840949694186L;
    private Integer id;
    private String paintingPath;
    private String paintingAuthor;
    private String paintingInfo;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDate;
    private Date createdTime;
    @JsonIgnore
    private Integer isDeleted;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getPaintingPath() {
        return paintingPath;
    }

    public void setPaintingPath(String paintingPath) {
        this.paintingPath = paintingPath;
    }

    public String getPaintingAuthor() {
        return paintingAuthor;
    }

    public void setPaintingAuthor(String paintingAuthor) {
        this.paintingAuthor = paintingAuthor;
    }

    public String getPaintingInfo() {
        return paintingInfo;
    }

    public void setPaintingInfo(String paintingInfo) {
        this.paintingInfo = paintingInfo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getShowingDate() {
        return showingDate;
    }

    public void setShowingDate(Date showingDate) {
        this.showingDate = showingDate;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "IslandPainting{" +
                "id=" + id +
                ", paintingPath='" + paintingPath + '\'' +
                ", paintingAuthor='" + paintingAuthor + '\'' +
                ", paintingInfo='" + paintingInfo + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", showingDate=" + showingDate +
                ", createdTime=" + createdTime +
                ", isDeleted='" + isDeleted + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
