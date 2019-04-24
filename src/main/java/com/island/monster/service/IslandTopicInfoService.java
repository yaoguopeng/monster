package com.island.monster.service;

import com.island.monster.bean.IslandTopic;
import com.island.monster.bean.IslandTopicInfo;

public interface IslandTopicInfoService {

    IslandTopicInfo add(String topicId);

    IslandTopicInfo topicVisitTimesIncrease(String topicId);

    IslandTopicInfo topicVisitTimesIncrease(IslandTopic islandTopic);

    IslandTopicInfo getByTopicId(String topicId);

}
