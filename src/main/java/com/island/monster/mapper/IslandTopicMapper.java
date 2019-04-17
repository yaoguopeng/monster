package com.island.monster.mapper;

import com.island.monster.bean.IslandTopic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandTopicMapper {

    int insertSelective(IslandTopic islandTopic);

    IslandTopic selectByPrimaryKey(String id);

    IslandTopic selectByTopicName(@Param("topicName") String topicName);

    List<IslandTopic> getByConditions(IslandTopic islandTopic);

    int setDeleted(String id);

    List<IslandTopic> onesFavoriteTopic(@Param("unionId") String unionId);

}

