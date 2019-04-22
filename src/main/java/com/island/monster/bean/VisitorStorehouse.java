package com.island.monster.bean;

import java.io.Serializable;
import java.util.Date;
import com.island.monster.common.IslandCommon.WorkType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 时光小岛游客收藏
 */
public class VisitorStorehouse  implements Serializable {

    private static final long serialVersionUID = -2909097915507554824L;
    private String id;
    @NotEmpty
    private String unionId;
    @NotNull
    private Integer workId;
    @NotEmpty
    private String workType;// 作品类型 IslandCommon.WorkType
    private String storedCancel;
    private Date cancelTime;
    private Date firstStoredTime;
    private Date lastStoredTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getStoredCancel() {
        return storedCancel;
    }

    public void setStoredCancel(String storedCancel) {
        this.storedCancel = storedCancel;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getFirstStoredTime() {
        return firstStoredTime;
    }

    public void setFirstStoredTime(Date firstStoredTime) {
        this.firstStoredTime = firstStoredTime;
    }

    public Date getLastStoredTime() {
        return lastStoredTime;
    }

    public void setLastStoredTime(Date lastStoredTime) {
        this.lastStoredTime = lastStoredTime;
    }
}
