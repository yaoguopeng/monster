package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛诗歌
 */
public class IslandPoem implements Serializable {

    private static final long serialVersionUID = 4622295286103137951L;
    private Integer id;
    private String poemTitle;
    private String poemType;
    private String poemAuthor;
    private String poemContent;
    private String poemNote;
    private String poemExplanation;
    private String poemAppreciation;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDate;
    private Date createdTime;
    @JsonIgnore
    private String isDeleted;

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoemTitle() {
        return poemTitle;
    }

    public void setPoemTitle(String poemTitle) {
        this.poemTitle = poemTitle;
    }

    public String getPoemType() {
        return poemType;
    }

    public void setPoemType(String poemType) {
        this.poemType = poemType;
    }

    public String getPoemAuthor() {
        return poemAuthor;
    }

    public void setPoemAuthor(String poemAuthor) {
        this.poemAuthor = poemAuthor;
    }

    public String getPoemContent() {
        return poemContent;
    }

    public void setPoemContent(String poemContent) {
        this.poemContent = poemContent;
    }

    public String getPoemNote() {
        return poemNote;
    }

    public void setPoemNote(String poemNote) {
        this.poemNote = poemNote;
    }

    public String getPoemExplanation() {
        return poemExplanation;
    }

    public void setPoemExplanation(String poemExplanation) {
        this.poemExplanation = poemExplanation;
    }

    public String getPoemAppreciation() {
        return poemAppreciation;
    }

    public void setPoemAppreciation(String poemAppreciation) {
        this.poemAppreciation = poemAppreciation;
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
        return "IslandPoem{" +
                "poemTitle='" + poemTitle + '\'' +
                ", poemType='" + poemType + '\'' +
                ", poemAuthor='" + poemAuthor + '\'' +
                ", poemContent='" + poemContent + '\'' +
                ", poemNote='" + poemNote + '\'' +
                ", poemExplanation='" + poemExplanation + '\'' +
                ", poemAppreciation='" + poemAppreciation + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", showingDate=" + showingDate +
                ", createdTime=" + createdTime +
                '}';
    }
}
