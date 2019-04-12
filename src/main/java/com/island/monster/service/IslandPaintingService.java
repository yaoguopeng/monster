package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPainting;

import java.util.List;

public interface IslandPaintingService {

    IslandPainting add(IslandPainting islandPainting);

    IslandPainting remove(Integer id);

    IslandPainting setDel(Integer id);

    IslandPainting edit(IslandPainting islandPainting);

    IslandPainting getOne(IslandPainting islandPainting);

    IslandPainting nextPainting(Integer currentId);

    IslandPainting randomPainting();

    List<IslandPainting> getList(IslandPainting islandPainting);

    PageInfo<IslandPainting> getPage(IslandPainting islandPainting, Integer pageNum, Integer pageSize);
}
