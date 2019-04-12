package com.island.monster.mapper;

import com.island.monster.bean.IslandTopicInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IslandTopicInfoMapper {

    Long getVisitTimesByTopicId(String topicId);

    IslandTopicInfo getByTopicId(String topicId);

    int insertSelective(IslandTopicInfo islandTopicInfo);

    int updateSelective(IslandTopicInfo islandTopicInfo);
}
