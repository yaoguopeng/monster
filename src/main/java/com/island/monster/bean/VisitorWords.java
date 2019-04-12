package com.island.monster.bean;

import java.io.Serializable;
import java.util.Date;
import com.island.monster.common.IslandCommon.WorkType;

/**
 * 时光小岛游客点评互动
 */
public class VisitorWords  implements Serializable {

    private static final long serialVersionUID = 4227809763803115473L;
    private String id;
    private String workId;
    private WorkType workType; // 作品类型 IslandCommon.WorkType
    private String wordsContent;
    private String wordsId;
    private String unionId;
    private Date createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public String getWordsContent() {
        return wordsContent;
    }

    public void setWordsContent(String wordsContent) {
        this.wordsContent = wordsContent;
    }

    public String getWordsId() {
        return wordsId;
    }

    public void setWordsId(String wordsId) {
        this.wordsId = wordsId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
