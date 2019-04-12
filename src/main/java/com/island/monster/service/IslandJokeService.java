package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandJoke;

import java.util.List;

public interface IslandJokeService {

    IslandJoke randomJoke();

    IslandJoke nextJoke(Integer currentId);

    IslandJoke add(IslandJoke islandJoke);

    IslandJoke edit(IslandJoke islandJoke);

    List<IslandJoke> getList(IslandJoke islandJoke);

    PageInfo<IslandJoke> getPage(IslandJoke islandJoke, Integer pageNum, Integer pageSize);

}
