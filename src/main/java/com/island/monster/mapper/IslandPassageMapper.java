package com.island.monster.mapper;

import com.island.monster.bean.IslandPassage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandPassageMapper {

    int insertSelective(IslandPassage islandPassage);

    int delete(Integer id);

    int setDel(Integer id);

    int updateByPrimaryKeySelective(IslandPassage islandPassage);

    IslandPassage selectByPrimaryKey(@Param("id") Integer id);

    IslandPassage nextPassage(@Param("currentId") Integer currentId);

    IslandPassage previousPassage(@Param("currentId") Integer currentId);

    List<IslandPassage> getByConditions(IslandPassage islandPassage);

    int getMaxId();

    int getMinId();

    List<IslandPassage> onesFavorite(@Param("unionId")String unionId, @Param("storedCancel") String storedCancel);
}
