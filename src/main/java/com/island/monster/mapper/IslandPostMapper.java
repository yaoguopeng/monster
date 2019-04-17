package com.island.monster.mapper;

import com.island.monster.bean.IslandPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandPostMapper {

    Long getPostAmountsByTopicId(@Param("topicId") String topicId);

    int insertSelective(IslandPost islandPost);

    int updateByPrimaryKeySelective(IslandPost islandPost);

    /**
     * only active post will be return
     *
     * @param id
     * @return
     */
    IslandPost selectByPrimaryKey(String id);

    int remove(String id);

    /**
     * only active posts will be return
     *
     * @param islandPost
     * @return
     */
    List<IslandPost> getByConditions(IslandPost islandPost);

    int setDeleted(String id);
}
