package com.island.monster.mapper;

import com.island.monster.bean.IslandPostInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IslandPostInfoMapper {

    int insertSelective(IslandPostInfo islandPostInfo);

    int updateSelective(IslandPostInfo islandPostInfo);

    int delete(String postId);

    Integer getVisitTimesByPostId(String postId);

    IslandPostInfo getByPostId(String postId);
}
