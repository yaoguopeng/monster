package com.island.monster.bean;

import java.io.Serializable;
import java.util.Date;
import com.island.monster.common.IslandCommon.WorkType;

import javax.validation.constraints.NotEmpty;

/**
 * 时光小岛游客收藏
 */
public class VisitorStorehouse  implements Serializable {

    private static final long serialVersionUID = -2909097915507554824L;
    private String id;
    @NotEmpty
    private String unionId;
    @NotEmpty
    private Integer workId;
    @NotEmpty
    private WorkType workType;// 作品类型 IslandCommon.WorkType
    private String storedCancel;
    private Date cancelTime;
    private Date storedTime;

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

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
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

    public Date getStoredTime() {
        return storedTime;
    }

    public void setStoredTime(Date storedTime) {
        this.storedTime = storedTime;
    }
}
