package com.island.monster.service;


import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPassage;

import java.util.List;

public interface IslandPassageService {

    IslandPassage getById(Integer id);

    IslandPassage add(IslandPassage islandPassage);

    IslandPassage remove(Integer id);

    IslandPassage setDel (Integer id);

    IslandPassage edit(IslandPassage islandPassage);

    IslandPassage getOne(IslandPassage islandPassage);

    IslandPassage nextPassage(Integer currentId);

    IslandPassage randomPassage();

    List<IslandPassage> getList(IslandPassage islandPassage);

    PageInfo<IslandPassage> getPage(IslandPassage islandPassage, Integer pageNum, Integer pageSize);
}
