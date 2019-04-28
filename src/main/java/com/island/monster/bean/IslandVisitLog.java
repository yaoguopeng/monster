package com.island.monster.bean;

import com.island.monster.common.IslandCommon;

import java.io.Serializable;
import java.util.Date;

/**
 * 来趣星小程序访客日志
 */
public class IslandVisitLog implements Serializable {

    private static final long serialVersionUID = 2568424486445491145L;

    private String id;
    private String unionId;
    private String visitObjectId;
    private IslandCommon.VisitObjectType visitObjectType;
    private Date visitTime;

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

    public String getVisitObjectId() {
        return visitObjectId;
    }

    public void setVisitObjectId(String visitObjectId) {
        this.visitObjectId = visitObjectId;
    }

    public IslandCommon.VisitObjectType getVisitObjectType() {
        return visitObjectType;
    }

    public void setVisitObjectType(IslandCommon.VisitObjectType visitObjectType) {
        this.visitObjectType = visitObjectType;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return "IslandVisitLog{" +
                "id='" + id + '\'' +
                ", unionId='" + unionId + '\'' +
                ", visitObjectId='" + visitObjectId + '\'' +
                ", visitObjectType=" + visitObjectType +
                ", visitTime=" + visitTime +
                '}';
    }
}
