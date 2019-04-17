package com.island.monster.service;

import com.island.monster.bean.IslandPostThumbsUp;

import java.util.List;

public interface IslandPostThumbsUpService {

    IslandPostThumbsUp add(IslandPostThumbsUp islandPostThumbsUp);

    int remove(IslandPostThumbsUp islandPostThumbsUp);

    List<IslandPostThumbsUp> getList(IslandPostThumbsUp islandPostThumbsUp);
}
