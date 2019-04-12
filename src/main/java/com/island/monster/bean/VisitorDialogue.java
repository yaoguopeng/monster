package com.island.monster.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 时光小岛用户对话
 */
public class VisitorDialogue implements Serializable {

    private static final long serialVersionUID = -7438068581769719581L;
    private String id;
    private String voiceFrom;
    private String voiceTo;
    private String voiceContent;
    private String isRead;
    private String isDeleted;
    private Date createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoiceFrom() {
        return voiceFrom;
    }

    public void setVoiceFrom(String voiceFrom) {
        this.voiceFrom = voiceFrom;
    }

    public String getVoiceTo() {
        return voiceTo;
    }

    public void setVoiceTo(String voiceTo) {
        this.voiceTo = voiceTo;
    }

    public String getVoiceContent() {
        return voiceContent;
    }

    public void setVoiceContent(String voiceContent) {
        this.voiceContent = voiceContent;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
