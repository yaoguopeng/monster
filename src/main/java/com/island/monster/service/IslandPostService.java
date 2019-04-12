package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPost;

import java.util.List;

public interface IslandPostService {

    IslandPost getOne(String id);

    IslandPost setDeleted(String id);

    List<IslandPost> getList(IslandPost islandPost);

    PageInfo<IslandPost> getPage(IslandPost islandPost, Integer pageNum, Integer pageSize);
}
