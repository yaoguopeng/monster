package com.island.monster.mapper;

import com.island.monster.bean.IslandIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandIndexMapper {

    int insertSelective(IslandIndex islandIndex);

    int updateSelective(IslandIndex islandIndex);

    IslandIndex selectByPrimaryKey(Integer id);

    List<IslandIndex> getByConditions(IslandIndex islandIndex);

    IslandIndex nextIndex(@Param("currentId")Integer currentId);

    int getMaxId();

    int getMinId();
}
