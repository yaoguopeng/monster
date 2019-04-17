package com.island.monster.mapper;

import com.island.monster.bean.IslandMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandMovieMapper {

    int insertSelective(IslandMovie islandMovie);

    int delete(Integer id);

    int setDel(Integer id);

    int updateByPrimaryKeySelective(IslandMovie islandMovie);

    IslandMovie selectByPrimaryKey(@Param("id") Integer id);

    IslandMovie nextMovie(@Param("currentId") Integer currentId);

    IslandMovie previousMovie(@Param("currentId") Integer currentId);

    List<IslandMovie> getByConditions(IslandMovie islandMovie);

    int getMaxId();

    int getMinId();

    List<IslandMovie> onesFavorite(@Param("unionId")String unionId, @Param("storedCancel") String storedCancel);
}
