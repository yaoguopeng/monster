package com.island.monster.mapper;

import com.island.monster.bean.IslandVisitor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandVisitorMapper {

    int insertSelective(IslandVisitor islandVisitor);

    int updateByPrimaryKeySelective(IslandVisitor islandVisitor);

    IslandVisitor selectByUnionId(@Param("unionId") String unionId);

    List<IslandVisitor> getThumbsUpVisitorByPostId(String postId);
}
