package com.island.monster.service.impl;

import com.island.monster.bean.IslandManager;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandManagerMapper;
import com.island.monster.service.IslandManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.redis.core.RedisTemplate;

@Service
public class IslandManagerServiceImpl implements IslandManagerService {

    @Autowired
    private IslandManagerMapper islandManagerMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public IslandManager edit(IslandManager islandManager) {
        // TODO check checkCode
        String redisCheckCode = redisTemplate.opsForValue().get(islandManager.getId() + islandManager.getBindEmail());
        if (redisCheckCode == null || !redisCheckCode.equals(islandManager.getCheckCode())) {
            // there is no checkCode in redis for the phone number provided or
            return null;
        }
        // edit the information of manager and set current time as updateTime
        islandManager.setUpdateTime(IslandUtil.now());
        islandManagerMapper.updateByPrimaryKeySelective(islandManager);
        islandManager.setRegistePassword(null);
        return islandManager;
    }

    @Override
    public Boolean login(IslandManager islandManager) {
        // only when the list is not empty
        return !islandManagerMapper.getByConditions(islandManager).isEmpty();
    }

    @Override
    public IslandManager add(IslandManager islandManager) {
        IslandManager condition = new IslandManager();
        condition.setRegisteName(islandManager.getRegisteName());
        if (!islandManagerMapper.getByConditions(condition).isEmpty()) {
            // there is already a Manager that use the same registName
            return null;
        }
        // use uuid as the primarykey of island manager
        islandManager.setId(IslandUtil.uuid());
        // use current time as registeTime
        islandManager.setRegisteTime(IslandUtil.now());
        islandManagerMapper.insertSelective(islandManager);
        islandManager.setRegistePassword(null);
        return islandManager;
    }

    public IslandManager getOne(String id) {
        return islandManagerMapper.selectByPrimaryKey(id);
    }
}
