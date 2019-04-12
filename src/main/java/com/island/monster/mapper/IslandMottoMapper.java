package com.island.monster.mapper;

import com.island.monster.bean.IslandMotto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandMottoMapper {

    int insertSelective(IslandMotto islandMotto);

    int updateByPrimaryKeySelective(IslandMotto islandMotto);

    List<IslandMotto> getByConditions(IslandMotto islandMotto);

    IslandMotto selectByPrimaryKey(@Param("id") Integer id);

    IslandMotto nextMotto(@Param("currentId") Integer currentId);

    IslandMotto previousMotto(@Param("currentId") Integer currentId);

    int getMaxId();

    int getMinId();

    List<IslandMotto> onesFavorite(@Param("unionId")String unionId);
}
