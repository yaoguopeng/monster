package com.island.monster.service.impl;

import com.island.monster.bean.IslandPostThumbsUp;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandPostThumbsUpMapper;
import com.island.monster.service.IslandPostThumbsUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandPostThumbsUpServiceImpl implements IslandPostThumbsUpService {

    @Autowired
    private IslandPostThumbsUpMapper islandPostThumbsUpMapper;

    @Override
    public IslandPostThumbsUp add(IslandPostThumbsUp islandPostThumbsUp) {
        islandPostThumbsUp.setId(IslandUtil.uuid());
        islandPostThumbsUp.setCreatedTime(IslandUtil.now());
        islandPostThumbsUpMapper.insertSelective(islandPostThumbsUp);
        return islandPostThumbsUp;
    }

    @Override
    public int remove(IslandPostThumbsUp islandPostThumbsUp) {
        return islandPostThumbsUpMapper.remove(islandPostThumbsUp);
    }

    @Override
    public List<IslandPostThumbsUp> getList(IslandPostThumbsUp islandPostThumbsUp) {
        return islandPostThumbsUpMapper.getByConditions(islandPostThumbsUp);
    }
}
