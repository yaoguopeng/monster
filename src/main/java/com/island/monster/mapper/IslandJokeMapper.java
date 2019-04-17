package com.island.monster.mapper;

import com.island.monster.bean.IslandJoke;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandJokeMapper {

    int getMaxId();

    int getMinId();

    IslandJoke selectByPrimaryKey(Integer id);

    IslandJoke nextJoke(@Param("currentId") Integer currentId);

    IslandJoke previousJoke(@Param("currentId") Integer currentId);

    int insertSelective(IslandJoke islandJoke);

    int updateSelective(IslandJoke islandJoke);

    List<IslandJoke> getByConditions(IslandJoke islandJoke);

    List<IslandJoke> onesFavorite(@Param("unionId") String unionId, @Param("storedCancel") String storedCancel);
}
