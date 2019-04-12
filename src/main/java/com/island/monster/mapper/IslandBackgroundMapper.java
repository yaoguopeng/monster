package com.island.monster.mapper;

import com.island.monster.bean.IslandBackground;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandBackgroundMapper {

    int insertSelective(IslandBackground islandBackground);

    int updateSelective(IslandBackground islandBackground);

    IslandBackground selectByPrimaryKey(Integer id);

    IslandBackground nextBackground(@Param("currentId")Integer currentId);

    List<IslandBackground> getByConditions(IslandBackground islandBackground);

    int getMaxId();

    int getMinId();

}
