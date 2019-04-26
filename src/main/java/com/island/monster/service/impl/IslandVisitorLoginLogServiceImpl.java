package com.island.monster.service.impl;

import com.island.monster.bean.IslandVisitor;
import com.island.monster.bean.IslandVisitorLoginLog;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandVisitorLoginLogMapper;
import com.island.monster.service.IslandVisitorLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IslandVisitorLoginLogServiceImpl implements IslandVisitorLoginLogService {

    @Autowired
    private IslandVisitorLoginLogMapper islandVisitorLoginLogMapper;

    @Override
    public void addLoginLog(IslandVisitor islandVisitor) {
        IslandVisitorLoginLog islandVisitorLoginLog = new IslandVisitorLoginLog();
        islandVisitorLoginLog.setId(IslandUtil.uuid());
        islandVisitorLoginLog.setLoginTime(IslandUtil.now());
        islandVisitorLoginLog.setUnionId(islandVisitor.getUnionId());
        islandVisitorLoginLog.setLoginOrdinal(islandVisitorLoginLogMapper.getMaxOrdinal(islandVisitor.getUnionId())+1);
        islandVisitorLoginLogMapper.insertSelective(islandVisitorLoginLog);
    }
}
