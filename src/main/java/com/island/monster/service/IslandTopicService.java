package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandTopic;

import java.util.List;

public interface IslandTopicService {

    IslandTopic add(IslandTopic islandTopic);

    IslandTopic setDeleted(String id);

    IslandTopic getByTopicName(String topicName);

    IslandTopic getOne(String id);

    List<IslandTopic> getList(String sortBy, IslandTopic islandTopic);

    PageInfo<IslandTopic> getPage(IslandTopic islandTopic, String sortBy, Integer pageNum, Integer pageSize);

    List<IslandTopic> onesFavoriteTopic(String sortBy, String unionId);

    PageInfo<IslandTopic> onesFavoriteTopic(String unionId, String sortBy, Integer pageNum, Integer pageSize);
}
