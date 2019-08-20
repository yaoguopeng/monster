package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛美文
 */
public class IslandPassage implements Serializable {

    private static final long serialVersionUID = 9167936729151742905L;
    private Integer id;
    private String passageTitle;
    private String passageFrom;
    private String passageAuthor;
    private String passageContent;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDate;
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

    public String getPassageTitle() {
        return passageTitle;
    }

    public void setPassageTitle(String passageTitle) {
        this.passageTitle = passageTitle;
    }

    public String getPassageFrom() {
        return passageFrom;
    }

    public void setPassageFrom(String passageFrom) {
        this.passageFrom = passageFrom;
    }

    public String getPassageAuthor() {
        return passageAuthor;
    }

    public void setPassageAuthor(String passageAuthor) {
        this.passageAuthor = passageAuthor;
    }

    public String getPassageContent() {
        return passageContent;
    }

    public void setPassageContent(String passageContent) {
        this.passageContent = passageContent;
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
        return "IslandPassage{" +
                "passageTitle='" + passageTitle + '\'' +
                ", passageFrom='" + passageFrom + '\'' +
                ", passageAuthor='" + passageAuthor + '\'' +
                ", passageContent='" + passageContent + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", showingDate=" + showingDate +
                ", createdTime=" + createdTime +
                '}';
    }
}
