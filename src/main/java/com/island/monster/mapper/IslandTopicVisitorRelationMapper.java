package com.island.monster.mapper;

import com.island.monster.bean.IslandTopicVisitorRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface IslandTopicVisitorRelationMapper {

    int insertSelective(IslandTopicVisitorRelation islandTopicVisitorRelation);

    IslandTopicVisitorRelation getOne(@Param("topicId") String topicId, @Param("unionId") String unionId, @Param("isCancel") String isCancel);

    int updateByPrimaryKeySelective(IslandTopicVisitorRelation islandTopicVisitorRelation);

    int setDeleted(@Param("topicId") String topicId, @Param("unionId") String unionId, @Param("updatedTime") Date updatedTime);
}
