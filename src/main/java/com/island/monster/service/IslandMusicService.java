package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandMusic;

import java.util.List;

public interface IslandMusicService {

    IslandMusic getOne(IslandMusic islandMusic);

    IslandMusic nextMusic(Integer currentId);

    IslandMusic randomMusic();

    IslandMusic add(IslandMusic islandMusic);

    IslandMusic edit(IslandMusic islandMusic);

    IslandMusic remove(Integer id);

    IslandMusic setDel(Integer id);

    List<IslandMusic> getList(IslandMusic islandMusic);

    PageInfo<IslandMusic> getPage(IslandMusic islandMusic, Integer pageNum, Integer pageSize);
}
