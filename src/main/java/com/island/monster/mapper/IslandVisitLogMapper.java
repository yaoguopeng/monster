package com.island.monster.mapper;

import com.island.monster.bean.IslandVisitLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IslandVisitLogMapper {

    int insertSelective(IslandVisitLog islandVisitLog);

    List<IslandVisitLog> selectByUnionId(String unionId);

}
