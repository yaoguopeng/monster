package com.island.monster.mapper;

import com.island.monster.bean.IslandMusic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandMusicMapper {

    int insertSelective(IslandMusic islandMusic);

    int delete(Integer id);

    int setDel(Integer id);

    int updateByPrimaryKeySelective(IslandMusic islandMusic);

    IslandMusic selectByPrimaryKey(@Param("id") Integer id);

    IslandMusic nextMusic(@Param("currentId") Integer currentId);

    IslandMusic previousMusic(@Param("currentId") Integer currentId);

    List<IslandMusic> getByConditions(IslandMusic islandMusic);

    int getMaxId();

    int getMinId();

    List<IslandMusic> onesFavorite(@Param("unionId")String unionId, @Param("storedCancel") String storedCancel);
}
