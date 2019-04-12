package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandLandscape;

import java.util.List;

public interface IslandLandscapeService {

    IslandLandscape randomLandscape();

    IslandLandscape nextLandscape(Integer currentId);

    IslandLandscape getOne(IslandLandscape islandLandscape);

    List<IslandLandscape> getList(IslandLandscape islandLandscape);

    PageInfo<IslandLandscape> getPage(IslandLandscape islandLandscape, Integer pageNum, Integer pageSize);

}
