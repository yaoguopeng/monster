package com.island.monster.service.impl;

import com.island.monster.bean.IslandTopic;
import com.island.monster.bean.IslandTopicVisitorRelation;
import com.island.monster.common.IslandCommon;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandTopicMapper;
import com.island.monster.mapper.IslandTopicVisitorRelationMapper;
import com.island.monster.service.IslandTopicVisitorRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IslandTopicVisitorRelationServiceImpl implements IslandTopicVisitorRelationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandTopicVisitorRelationServiceImpl.class);


    @Autowired
    private IslandTopicVisitorRelationMapper islandTopicVisitorRelationMapper;

    @Autowired
    private IslandTopicMapper islandTopicMapper;

    @Override
    public IslandTopicVisitorRelation add(IslandTopicVisitorRelation islandTopicVisitorRelation) {
        // 检查主题是否存在
        IslandTopic topic = islandTopicMapper.selectByPrimaryKey(islandTopicVisitorRelation.getTopicId());
        if (topic == null) {
            LOGGER.info("topicId={}的主题不存在！", islandTopicVisitorRelation.getTopicId());
            return null;
        }
        // 检查是否曾有已取消关注记录
        IslandTopicVisitorRelation target = islandTopicVisitorRelationMapper.getOne(islandTopicVisitorRelation.getTopicId(), islandTopicVisitorRelation.getUnionId(), IslandCommon.yes());
        if (target == null) {
            islandTopicVisitorRelation.setId(IslandUtil.uuid());
            islandTopicVisitorRelation.setCreatedTime(IslandUtil.now());
            islandTopicVisitorRelationMapper.insertSelective(islandTopicVisitorRelation);
            LOGGER.info("{}关注了话题：{}", islandTopicVisitorRelation.getUnionId(), topic.getTopicName());
            return islandTopicVisitorRelation;
        } else {
            target.setIsCancel(IslandCommon.no());
            target.setUpdatedTime(IslandUtil.now());
            islandTopicVisitorRelationMapper.updateByPrimaryKeySelective(target);
            LOGGER.info("{}重新关注了话题：{}", islandTopicVisitorRelation.getUnionId(), topic.getTopicName());
            return target;
        }
    }

    @Override
    public int cancel(IslandTopicVisitorRelation islandTopicVisitorRelation) {
        IslandTopic topic = islandTopicMapper.selectByPrimaryKey(islandTopicVisitorRelation.getTopicId());
        if (topic == null) {
            LOGGER.info("topicId={}的主题不存在！", islandTopicVisitorRelation.getTopicId());
            return 0;
        }
        LOGGER.info("{}取关话题：{}", islandTopicVisitorRelation.getUnionId(), topic.getTopicName());
        return islandTopicVisitorRelationMapper.setDeleted(islandTopicVisitorRelation.getTopicId(), islandTopicVisitorRelation.getUnionId(), IslandUtil.now());
    }
}
