package com.island.monster.mapper;

import com.island.monster.bean.IslandPostThumbsUp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandPostThumbsUpMapper {

    Integer getThumbsUpAmountsByPostId(@Param("topicId") String postId);

    int insertSelective(IslandPostThumbsUp islandPostThumbsUp);

    /**
     * postId and  thumbsUpBy must be not empty
     *
     * @param islandPostThumbsUp
     * @return
     */
    int remove(IslandPostThumbsUp islandPostThumbsUp);

    int removeById(String id);

    int removeByPostId(String postId);

    IslandPostThumbsUp selectByPrimaryKey(String id);

    List<IslandPostThumbsUp> getByConditions(IslandPostThumbsUp islandPost);

}
