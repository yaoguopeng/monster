package com.island.monster.mapper;

import com.island.monster.bean.IslandPainting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandPaintingMapper {

    int insertSelective(IslandPainting islandPainting);

    int delete(Integer id);

    int setDel(Integer id);

    int updateByPrimaryKeySelective(IslandPainting islandPainting);

    IslandPainting selectByPrimaryKey(@Param("id") Integer id);

    IslandPainting nextPainting(@Param("currentId") Integer currentId);

    IslandPainting previousPainting(@Param("currentId") Integer currentId);

    List<IslandPainting> getByConditions(IslandPainting islandPainting);

    int getMaxId();

    int getMinId();

    List<IslandPainting> onesFavorite(@Param("unionId")String unionId, @Param("storedCancel") String storedCancel);
}
