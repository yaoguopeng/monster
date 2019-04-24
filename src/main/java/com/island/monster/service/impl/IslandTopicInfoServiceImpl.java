package com.island.monster.service.impl;

import com.island.monster.bean.IslandTopic;
import com.island.monster.bean.IslandTopicInfo;
import com.island.monster.mapper.IslandTopicInfoMapper;
import com.island.monster.mapper.IslandTopicMapper;
import com.island.monster.service.IslandTopicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IslandTopicInfoServiceImpl implements IslandTopicInfoService {

    @Autowired
    private IslandTopicInfoMapper islandTopicInfoMapper;

    @Autowired
    private IslandTopicMapper islandTopicMapper;


    @Override
    public IslandTopicInfo add(String topicId) {
        IslandTopicInfo islandTopicInfo = new IslandTopicInfo();
        islandTopicInfo.setTopicId(topicId);
        islandTopicInfo.setTopicVisitTimes(0);
        islandTopicInfoMapper.insertSelective(islandTopicInfo);
        return islandTopicInfo;
    }

    @Override
    public IslandTopicInfo topicVisitTimesIncrease(String topicId) {
        if (getByTopicId(topicId) == null) {
            return null;
        }
        IslandTopicInfo target = getByTopicId(topicId);
        if (target == null) {
            return add(topicId);
        }
        target.setTopicVisitTimes(target.getTopicVisitTimes() + 1);
        islandTopicInfoMapper.updateSelective(target);
        return target;
    }

    @Override
    public IslandTopicInfo topicVisitTimesIncrease(IslandTopic islandTopic) {
        return topicVisitTimesIncrease(islandTopic.getId());
    }

    @Override
    public IslandTopicInfo getByTopicId(String topicId) {
        return islandTopicInfoMapper.getByTopicId(topicId);
    }
}
