package com.island.monster.service.impl;

import com.island.monster.bean.IslandVisitLog;
import com.island.monster.common.IslandCommon;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandVisitLogMapper;
import com.island.monster.service.IslandVisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IslandVisitLogServiceImpl implements IslandVisitLogService {

    @Autowired
    private IslandVisitLogMapper islandVisitLogMapper;

    @Override
    public IslandVisitLog addOne(String unionId, String visitObjectId, IslandCommon.VisitObjectType visitObjectType) {
        IslandVisitLog result = new IslandVisitLog();
        result.setId(IslandUtil.uuid());
        result.setUnionId(unionId);
        result.setVisitObjectId(visitObjectId);
        result.setVisitObjectType(visitObjectType);
        result.setVisitTime(IslandUtil.now());
        islandVisitLogMapper.insertSelective(result);
        return result;
    }

}
