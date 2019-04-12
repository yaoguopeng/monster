package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPoem;

import java.util.List;

public interface IslandPoemService {
    
    IslandPoem add(IslandPoem islandPoem);

    IslandPoem remove(Integer id);

    IslandPoem setDel (Integer id);

    IslandPoem edit(IslandPoem islandPoem);

    IslandPoem getOne(IslandPoem islandPoem);

    IslandPoem nextPoem(Integer currentId);

    IslandPoem randomPoem();

    List<IslandPoem> getList(IslandPoem islandPoem);

    PageInfo<IslandPoem> getPage(IslandPoem islandPoem, Integer pageNum, Integer pageSize);
}
