package com.island.monster.bean;



import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛访客信息
 */
public class IslandVisitor implements Serializable {

    private static final long serialVersionUID = -3716860751814102026L;
    private Integer id;
    @NotEmpty
    private String unionId;
    private Date firstLandingTime;
    private Date lastLandingTime;
    @NotEmpty
    private String nickName;
    @NotEmpty
    private String avatarPath;
    private Integer landingCount;
    private String tel;
    /**
     * 性别 0：未知、1：男、2：女
     */
    private String gender;
    /**
     * 语言：
     * en	英文
     * zh_CN	简体中文
     * zh_TW	繁体中文
     */
    private String language;
    private String city;
    private String province;
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Date getFirstLandingTime() {
        return firstLandingTime;
    }

    public void setFirstLandingTime(Date firstLandingTime) {
        this.firstLandingTime = firstLandingTime;
    }

    public Date getLastLandingTime() {
        return lastLandingTime;
    }

    public void setLastLandingTime(Date lastLandingTime) {
        this.lastLandingTime = lastLandingTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getLandingCount() {
        return landingCount;
    }

    public void setLandingCount(Integer landingCount) {
        this.landingCount = landingCount;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
