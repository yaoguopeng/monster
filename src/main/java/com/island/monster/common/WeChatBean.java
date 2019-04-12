package com.island.monster.common;

/**
 * 待解密数据结构体
 */
public class WeChatBean {

    /**
     * 小程序id
     */
    private String appid;
    /**
     * 小程序密钥
     */
    private String secret;
    /**
     * 算法参数偏移量
     */
    private String iv;
    /**
     * 登陆凭证
     */
    private String code;
    /**
     * 加密数据
     */
    private String encryptedData;
    /**
     * 算法密钥
     */
    private String key;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
