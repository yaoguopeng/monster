package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandTopic;

import java.util.List;

public interface IslandTopicService {

    IslandTopic add(IslandTopic islandTopic);

    IslandTopic setDeleted(String id);

    IslandTopic getByTopicName(String topicName);

    IslandTopic getOne(String id);

    List<IslandTopic> getList(IslandTopic islandTopic);

    PageInfo<IslandTopic> getPage(IslandTopic islandTopic, Integer pageNum, Integer pageSize);

    List<IslandTopic> onesFavoriteTopic(String unionId);

    PageInfo<IslandTopic> onesFavoriteTopic(String unionId, Integer pageNum, Integer pageSize);
}
