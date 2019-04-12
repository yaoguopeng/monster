package com.island.monster.service.impl;

import com.island.monster.bean.IslandTopicInfo;
import com.island.monster.mapper.IslandTopicInfoMapper;
import com.island.monster.service.IslandTopicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IslandTopicInfoServiceImpl implements IslandTopicInfoService {

    @Autowired
    private IslandTopicInfoMapper islandTopicInfoMapper;


    @Override
    public IslandTopicInfo add(IslandTopicInfo islandTopicInfo) {
        islandTopicInfoMapper.insertSelective(islandTopicInfo);
        return islandTopicInfoMapper.getByTopicId(islandTopicInfo.getTopicId());
    }

    @Override
    public IslandTopicInfo update(IslandTopicInfo islandTopicInfo) {
        islandTopicInfoMapper.updateSelective(islandTopicInfo);
        return islandTopicInfoMapper.getByTopicId(islandTopicInfo.getTopicId());
    }
}
