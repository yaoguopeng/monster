package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛格言
 */
public class IslandMotto implements Serializable {

    private static final long serialVersionUID = -5926468113209124789L;
    private Integer id;
    private String author;
    private String content;
    private String mottoFrom;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMottoFrom() {
        return mottoFrom;
    }

    public void setMottoFrom(String mottoFrom) {
        this.mottoFrom = mottoFrom;
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
        return "IslandMotto{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", mottoFrom='" + mottoFrom + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", showingDate=" + showingDate +
                ", createdTime=" + createdTime +
                '}';
    }
}
