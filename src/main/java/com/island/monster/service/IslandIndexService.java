package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandIndex;

import java.util.List;

public interface IslandIndexService {

    /**
     * get information of a index record
     *
     * @return
     */
    IslandIndex randomIndex();

    IslandIndex getById(Integer id);

    IslandIndex nextIndex(Integer currentId);

    IslandIndex getOne(IslandIndex islandIndex);

    List<IslandIndex> getList(IslandIndex islandIndex);

    PageInfo<IslandIndex> getPage(IslandIndex islandIndex, Integer pageNum, Integer pageSize);
}
