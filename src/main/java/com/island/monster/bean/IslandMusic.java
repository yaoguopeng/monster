package com.island.monster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛音乐
 */
public class IslandMusic implements Serializable {

    private static final long serialVersionUID = 7318503630152811289L;
    private Integer id;
    private String musicName;
    private String musicPath;
    private String musicSinger;
    private String musicAlbum;
    private String musicImagePath;
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

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public String getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(String musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public String getMusicImagePath() {
        return musicImagePath;
    }

    public void setMusicImagePath(String musicImagePath) {
        this.musicImagePath = musicImagePath;
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
        return "IslandMusic{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", musicPath='" + musicPath + '\'' +
                ", musicSinger='" + musicSinger + '\'' +
                ", musicAlbum='" + musicAlbum + '\'' +
                ", musicImagePath='" + musicImagePath + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", showingDate=" + showingDate +
                ", createdTime=" + createdTime +
                ", isDeleted='" + isDeleted + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
