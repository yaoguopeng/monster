package com.island.monster.mapper;

import com.island.monster.bean.IslandPoem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandPoemMapper {

    int insertSelective(IslandPoem islandPoem);

    int delete(Integer id);

    int setDel(Integer id);

    int updateByPrimaryKeySelective(IslandPoem islandPoem);

    IslandPoem selectByPrimaryKey(@Param("id") Integer id);

    IslandPoem nextPoem(@Param("currentId") Integer currentId);

    IslandPoem previousPoem(@Param("currentId") Integer currentId);

    List<IslandPoem> getByConditions(IslandPoem islandPoem);

    int getMaxId();

    int getMinId();

    List<IslandPoem> onesFavorite(@Param("unionId")String unionId);
}
