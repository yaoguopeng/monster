package com.island.monster.mapper;

import com.island.monster.bean.IslandVisitorRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IslandVisitorRelationMapper {

    int insertSelective(IslandVisitorRelation islandVisitorRelation);

    int updateByPrimaryKeySelective(IslandVisitorRelation islandVisitorRelation);

    IslandVisitorRelation getOne(@Param("fansId") String fansId, @Param("starId") String starId, @Param("concernCancel") String concernCancel);

}
