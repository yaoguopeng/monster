package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛欢迎页面内容
 */
public class IslandIndex implements Serializable {

    private static final long serialVersionUID = -3853770432423816090L;
    private Integer id;
    private String content;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDateBegin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDateEnd;
    private String createdBy;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getShowingDate() {
        return showingDate;
    }

    public void setShowingDate(Date showingDate) {
        this.showingDate = showingDate;
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
        return "IslandIndex{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", showingDate=" + showingDate +
                ", showingDateBegin=" + showingDateBegin +
                ", showingDateEnd=" + showingDateEnd +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
