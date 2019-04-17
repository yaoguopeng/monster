package com.island.monster.service.impl;

import com.island.monster.bean.IslandTopicVisitorRelation;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandTopicVisitorRelationMapper;
import com.island.monster.service.IslandTopicVisitorRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IslandTopicVisitorRelationServiceImpl implements IslandTopicVisitorRelationService {

    @Autowired
    private IslandTopicVisitorRelationMapper islandTopicVisitorRelationMapper;


    @Override
    public IslandTopicVisitorRelation add(IslandTopicVisitorRelation islandTopicVisitorRelation) {
        islandTopicVisitorRelation.setId(IslandUtil.uuid());
        islandTopicVisitorRelation.setCreatedTime(IslandUtil.now());
        islandTopicVisitorRelationMapper.insertSelective(islandTopicVisitorRelation);
        return islandTopicVisitorRelation;
    }

    @Override
    public int cancel(String id) {
        return islandTopicVisitorRelationMapper.setDeleted(id, IslandUtil.now());
    }
}
