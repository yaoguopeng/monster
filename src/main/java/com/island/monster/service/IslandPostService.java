package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPost;

import java.util.List;

public interface IslandPostService {

    IslandPost getOne(String id);

    /**
     * update: if there is one then edit it, otherwise add one
     *
     * @param islandPost
     * @return
     */
    IslandPost update(IslandPost islandPost);

    IslandPost setDeleted(String id);

    IslandPost remove(String id);

    List<IslandPost> getList(IslandPost islandPost);

    PageInfo<IslandPost> getPage(IslandPost islandPost, Integer pageNum, Integer pageSize);

    List<IslandPost> onesStarsPosts(String unionId);

    PageInfo<IslandPost> onesStarsPosts(String unionId, Integer pageNum, Integer pageSize);

    List<IslandPost> onesFavoriteTopicPosts(String unionId);

    PageInfo<IslandPost> onesFavoriteTopicPosts(String unionId, Integer pageNum, Integer pageSize);

    IslandPost postVisitedTimesIncrease(IslandPost islandPost);
}
