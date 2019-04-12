package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandBackground;

import java.util.List;

public interface IslandBackgroundService {

    IslandBackground randomBackground();

    IslandBackground nextBackground(Integer currentId);

    IslandBackground getOne(IslandBackground islandBackground);

    List<IslandBackground> getList(IslandBackground islandBackground);

    PageInfo<IslandBackground> getPage(IslandBackground islandBackground, Integer pageNum, Integer pageSize);
}
