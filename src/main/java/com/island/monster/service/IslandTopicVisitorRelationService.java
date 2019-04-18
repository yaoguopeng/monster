package com.island.monster.service;

import com.island.monster.bean.IslandTopicVisitorRelation;

public interface IslandTopicVisitorRelationService {

    IslandTopicVisitorRelation add(IslandTopicVisitorRelation islandTopicVisitorRelation);

    /**
     * topicId and unionId can not be empty
     *
     * @param islandTopicVisitorRelation
     * @return
     */
    int cancel(IslandTopicVisitorRelation islandTopicVisitorRelation);
}
