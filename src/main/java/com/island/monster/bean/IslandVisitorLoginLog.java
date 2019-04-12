package com.island.monster.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛游客登录记录
 */
public class IslandVisitorLoginLog implements Serializable {

    private static final long serialVersionUID = 7736715765791870814L;

    private String id;
    private String unionId;
    private Date loginTime;
    /**
     * 第几次登录
     */
    private Long loginOrdinal;


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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Long getLoginOrdinal() {
        return loginOrdinal;
    }

    public void setLoginOrdinal(Long loginOrdinal) {
        this.loginOrdinal = loginOrdinal;
    }
}
