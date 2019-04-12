package com.island.monster.mapper;

import com.island.monster.bean.IslandLandscape;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandLandscapeMapper {

    int insertSelective(IslandLandscape islandLandscape);

    int updateSelective(IslandLandscape islandLandscape);

    IslandLandscape selectByPrimaryKey(Integer id);

    IslandLandscape nextLandscape(@Param("currentId")Integer currentId);

    List<IslandLandscape> getByConditions(IslandLandscape islandLandscape);

    int getMaxId();

    int getMinId();
}
