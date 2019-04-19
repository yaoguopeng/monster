package com.island.monster.service.impl;

import com.island.monster.bean.IslandManager;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandManagerMapper;
import com.island.monster.service.IslandManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.redis.core.RedisTemplate;

@Service
public class IslandManagerServiceImpl implements IslandManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandManagerServiceImpl.class);

    @Autowired
    private IslandManagerMapper islandManagerMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * return manager with password encode by md5
     *
     * @param islandManager
     * @return
     */
    private IslandManager getEncodeManager(IslandManager islandManager) {
        islandManager.setRegisterPassword(IslandUtil.MD5Encode(islandManager.getRegisterPassword(), "utf-8"));
        return islandManager;
    }

    @Override
    public IslandManager edit(IslandManager islandManager) {
        // TODO check checkCode
        String redisCheckCode = redisTemplate.opsForValue().get(islandManager.getId() + islandManager.getBindEmail());
        if (redisCheckCode == null || !redisCheckCode.equals(islandManager.getCheckCode())) {
            // there is no checkCode in redis for the phone number provided or
            LOGGER.info("failed to edit cause the checkCode was wrong");
            return null;
        }
        // edit the information of manager and set current time as updateTime
        islandManager.setUpdateTime(IslandUtil.now());
        islandManagerMapper.updateByPrimaryKeySelective(islandManager);
        islandManager.setRegisterPassword(null);
        return islandManager;
    }

    @Override
    public Boolean login(IslandManager islandManager) {
        // only when the list is not empty
        return !islandManagerMapper.getByConditions(getEncodeManager(islandManager)).isEmpty();
    }

    @Override
    public IslandManager add(IslandManager islandManager) {
        if (islandManagerMapper.getByRegisterName(islandManager.getRegisterName())!=null) {
            // there is already a Manager that use the same registerName
            LOGGER.info("failed to register cause there was a manager with the same name exist");
            return null;
        }
        // use uuid as the primaryKey of island manager
        islandManager.setId(IslandUtil.uuid());
        // use current time as registerTime
        islandManager.setRegisterTime(IslandUtil.now());
        // encode password by md5 and insert into db
        islandManagerMapper.insertSelective(getEncodeManager(islandManager));
        islandManager.setRegisterPassword(null);
        return islandManager;
    }

    public IslandManager getOne(String id) {
        return islandManagerMapper.selectByPrimaryKey(id);
    }
}
