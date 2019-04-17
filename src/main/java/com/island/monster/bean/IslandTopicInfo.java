package com.island.monster.bean;

import java.io.Serializable;

/**
 * 主题信息，访问量处理需要支持高并发
 */
public class IslandTopicInfo implements Serializable {

    private static final long serialVersionUID = 6623487687832011L;
    private String topicId;
    private Integer topicVisitTimes;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Integer getTopicVisitTimes() {
        return topicVisitTimes;
    }

    public void setTopicVisitTimes(Integer topicVisitTimes) {
        this.topicVisitTimes = topicVisitTimes;
    }

}
