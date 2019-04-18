package com.island.monster.bean;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛用户关注关系
 */
public class IslandVisitorRelation implements Serializable {

    private static final long serialVersionUID = 7519400652988626811L;

    private String id;
    @NotEmpty(message = "fansId can not be empty")
    private String fansId;
    @NotEmpty(message = "starId can not be empty")
    private String starId;
    /**
     * 是否特别关注
     */
    private String isImportant;
    /**
     * 是否相互关注
     */
    private String isMutual;
    private String concernCancel;
    private Date createdTime;
    private Date updatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFansId() {
        return fansId;
    }

    public void setFansId(String fansId) {
        this.fansId = fansId;
    }

    public String getStarId() {
        return starId;
    }

    public void setStarId(String starId) {
        this.starId = starId;
    }

    public String getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(String isImportant) {
        this.isImportant = isImportant;
    }

    public String getIsMutual() {
        return isMutual;
    }

    public void setIsMutual(String isMutual) {
        this.isMutual = isMutual;
    }

    public String getConcernCancel() {
        return concernCancel;
    }

    public void setConcernCancel(String concernCancel) {
        this.concernCancel = concernCancel;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
