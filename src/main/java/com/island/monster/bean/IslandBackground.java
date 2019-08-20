package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛背景图
 */
public class IslandBackground implements Serializable {

    private static final long serialVersionUID = -4933431496589292904L;

    private Integer id;
    private String backgroundImagePath;
    private String  backgroundType; // com.island.monster.common.IslandCommon.WorkType
    private String createdBy;
    private String uuid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDateBegin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDateEnd;
    private Date createdTime;
    @JsonIgnore
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    public void setBackgroundImagePath(String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
    }

    public String getBackgroundType() {
        return backgroundType;
    }

    public void setBackgroundType(String backgroundType) {
        this.backgroundType = backgroundType;
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

    public Date getShowingDateBegin() {
        return showingDateBegin;
    }

    public void setShowingDateBegin(Date showingDateBegin) {
        this.showingDateBegin = showingDateBegin;
    }

    public Date getShowingDateEnd() {
        return showingDateEnd;
    }

    public void setShowingDateEnd(Date showingDateEnd) {
        this.showingDateEnd = showingDateEnd;
    }

    @Override
    public String toString() {
        return "IslandBackground{" +
                "id=" + id +
                ", backgroundImagePath='" + backgroundImagePath + '\'' +
                ", backgroundType='" + backgroundType + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", uuid='" + uuid + '\'' +
                ", showingDate=" + showingDate +
                ", showingDateBegin=" + showingDateBegin +
                ", showingDateEnd=" + showingDateEnd +
                ", createdTime=" + createdTime +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
