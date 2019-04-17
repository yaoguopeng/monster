package com.island.monster.mapper;

import com.island.monster.bean.IslandTopicVisitorRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface IslandTopicVisitorRelationMapper {

    int insertSelective(IslandTopicVisitorRelation islandTopicVisitorRelation);

    int setDeleted(@Param("id") String id,@Param("updatedTime") Date updatedTime);
}
