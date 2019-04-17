package com.island.monster.mapper;

import com.island.monster.bean.IslandPostReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IslandPostReplyMapper {

    Integer getPostReplyAmountsByPostId(@Param("postId") String postId);

    int insertSelective(IslandPostReply islandPostReply);

    IslandPostReply selectByPrimaryKey(String id);

    /**
     * only active postReplies will be return
     *
     * @param islandPostReply
     * @return
     */
    List<IslandPostReply> getByConditions(IslandPostReply islandPostReply);

    int updateByPrimaryKeySelective(IslandPostReply islandPostReply);

    int remove(String id);

    int removeByPostId(String postId);

    int setDeleted(String id);
}
