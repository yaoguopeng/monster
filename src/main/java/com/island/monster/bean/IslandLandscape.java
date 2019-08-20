package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛风景推荐
 */
public class IslandLandscape implements Serializable {

    private static final long serialVersionUID = -3279955479777779965L;

    private Integer id;
    private String landscapeImagePath;
    private String landscapeInfo;
    private String createdBy;
    private String uuid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDate;
    private Date createdTime;
    @JsonIgnore
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLandscapeImagePath() {
        return landscapeImagePath;
    }

    public void setLandscapeImagePath(String landscapeImagePath) {
        this.landscapeImagePath = landscapeImagePath;
    }

    public String getLandscapeInfo() {
        return landscapeInfo;
    }

    public void setLandscapeInfo(String landscapeInfo) {
        this.landscapeInfo = landscapeInfo;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "IslandLandscape{" +
                "id=" + id +
                ", landscapeImagePath='" + landscapeImagePath + '\'' +
                ", landscapeInfo='" + landscapeInfo + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", uuid='" + uuid + '\'' +
                ", showingDate=" + showingDate +
                ", createdTime=" + createdTime +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
