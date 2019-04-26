package com.island.monster.mapper;

import com.island.monster.bean.IslandVisitorLoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IslandVisitorLoginLogMapper {

    int insertSelective(IslandVisitorLoginLog islandVisitorLoginLog);

    List<IslandVisitorLoginLog> selectByUnionId(String unionId);

    Integer getMaxOrdinal(String unionId);
}
