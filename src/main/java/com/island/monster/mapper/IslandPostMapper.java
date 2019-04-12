package com.island.monster.mapper;

import com.island.monster.bean.IslandPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IslandPostMapper {

    Long getPostAmountsByTopicId(String topicId);

    int insertSelective(IslandPost islandPost);

    IslandPost selectByPrimaryKey(String id);

    List<IslandPost> getByConditions(IslandPost islandPost);

    int setDeleted(String id);
}
