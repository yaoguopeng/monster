package com.island.monster.service;

import com.island.monster.bean.IslandTopicVisitorRelation;

public interface IslandTopicVisitorRelationService {

    IslandTopicVisitorRelation add(IslandTopicVisitorRelation islandTopicVisitorRelation);

    int cancel(String id);
}
