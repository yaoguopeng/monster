package com.island.monster.mapper;

import com.island.monster.bean.IslandTopic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IslandTopicMapper {

    int insertSelective(IslandTopic islandTopic);

    IslandTopic selectByPrimaryKey(String id);

    List<IslandTopic> getByConditions(IslandTopic islandTopic);

    int setDeleted(String id);

}

