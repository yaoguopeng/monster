package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛电影分享
 */
public class IslandMovie implements Serializable {

    private static final long serialVersionUID = -8536712559485175690L;
    private Integer id;
    private String movieImagePath;
    private String movieBeautifulLines;
    private String movieName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showingDate;
    private Date createdTime;
    private String uuid;
    private String createdBy;
    @JsonIgnore
    private String isDeleted;

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieImagePath() {
        return movieImagePath;
    }

    public void setMovieImagePath(String movieImagePath) {
        this.movieImagePath = movieImagePath;
    }

    public String getMovieBeautifulLines() {
        return movieBeautifulLines;
    }

    public void setMovieBeautifulLines(String movieBeautifulLines) {
        this.movieBeautifulLines = movieBeautifulLines;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "IslandMovie{" +
                "id=" + id +
                ", movieImagePath='" + movieImagePath + '\'' +
                ", movieBeautifulLines='" + movieBeautifulLines + '\'' +
                ", movieName='" + movieName + '\'' +
                ", showingDate=" + showingDate +
                ", createdTime=" + createdTime +
                ", uuid='" + uuid + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
