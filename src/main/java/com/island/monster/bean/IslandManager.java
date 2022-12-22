package com.island.monster.bean;

import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛管理员
 */
public class IslandManager implements Serializable {

    private static final long serialVersionUID = -7501321651073283412L;
    private String id;
    private String realName;
    @NotEmpty(message = "registeName can not be empty")
    private String registeName;
    @NotEmpty(message = "registePassword can not be empty")
    private String registePassword;
    private String bindEmail;
    private Date registeTime;
    private Date updateTime;
    private String checkCode; // use when update password is need

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRegisteName() {
        return registeName;
    }

    public void setRegisteName(String registeName) {
        this.registeName = registeName;
    }

    public String getRegistePassword() {
        return registePassword;
    }

    public void setRegistePassword(String registePassword) {
        this.registePassword = registePassword;
    }

    public String getBindEmail() {
        return bindEmail;
    }

    public void setBindEmail(String bindEmail) {
        this.bindEmail = bindEmail;
    }

    public Date getRegisteTime() {
        return registeTime;
    }

    public void setRegisteTime(Date registeTime) {
        this.registeTime = registeTime;
    }
}
