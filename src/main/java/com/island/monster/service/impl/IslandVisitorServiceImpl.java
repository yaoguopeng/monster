package com.island.monster.service.impl;

import com.island.monster.common.IslandUtil;
import com.island.monster.bean.IslandVisitor;
import com.island.monster.mapper.IslandVisitorMapper;
import com.island.monster.service.IslandVisitorLoginLogService;
import com.island.monster.service.IslandVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IslandVisitorServiceImpl implements IslandVisitorService {

    @Autowired
    private IslandVisitorMapper islandVisitorMapper;

    @Autowired
    private  IslandVisitorLoginLogService islandVisitorLoginLogService;

    @Override
    public IslandVisitor update(IslandVisitor islandVisitor) {
        IslandVisitor target = islandVisitorMapper.selectByUnionId(islandVisitor.getUnionId());
        // 来访记录
        islandVisitorLoginLogService.addLoginLog(islandVisitor);
        if (target == null) {
            islandVisitor.setFirstLandingTime(IslandUtil.now());
            islandVisitor.setLandingCount(1);
            islandVisitor.setLastLandingTime(IslandUtil.now());
            islandVisitorMapper.insertSelective(islandVisitor);
            return islandVisitor;
        } else {
            target.setLandingCount(target.getLandingCount() + 1);
            target.setLastLandingTime(IslandUtil.now());
            target.setNickName(islandVisitor.getNickName());
            target.setAvatarPath(islandVisitor.getAvatarPath());
            islandVisitorMapper.updateByPrimaryKeySelective(target);
        }
        return target;
    }

    @Override
    public IslandVisitor getByUnionId(String unionId) {
        return islandVisitorMapper.selectByUnionId(unionId);
    }
}
