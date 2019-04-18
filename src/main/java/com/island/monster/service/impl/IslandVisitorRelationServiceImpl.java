package com.island.monster.service.impl;

import com.island.monster.bean.IslandVisitorRelation;
import com.island.monster.common.IslandCommon;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandVisitorRelationMapper;
import com.island.monster.service.IslandVisitorRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IslandVisitorRelationServiceImpl implements IslandVisitorRelationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandVisitorRelationServiceImpl.class);

    @Autowired
    private IslandVisitorRelationMapper islandVisitorRelationMapper;

    @Transactional
    @Override
    public IslandVisitorRelation addConcern(IslandVisitorRelation islandVisitorRelation) {
        // 检查是否已经存在已取消关注的历史记录
        IslandVisitorRelation target = islandVisitorRelationMapper.getOne(islandVisitorRelation.getFansId(), islandVisitorRelation.getStarId(), IslandCommon.yes());
        // 检查是否存在对方也正在关注
        IslandVisitorRelation result = islandVisitorRelationMapper.getOne(islandVisitorRelation.getStarId(), islandVisitorRelation.getFansId(), IslandCommon.no());
        if (target == null) {
            islandVisitorRelation.setId(IslandUtil.uuid());
            islandVisitorRelation.setCreatedTime(IslandUtil.now());
            if (result != null) {
                islandVisitorRelation.setIsMutual(IslandCommon.yes());
                result.setIsMutual(IslandCommon.yes());
                islandVisitorRelationMapper.updateByPrimaryKeySelective(result);
            }
            islandVisitorRelationMapper.insertSelective(islandVisitorRelation);
            LOGGER.info("{}关注了{}，是否相互关注：{}", islandVisitorRelation.getFansId(), islandVisitorRelation.getStarId(), islandVisitorRelation.getIsMutual());
            return islandVisitorRelation;
        } else {
            target.setConcernCancel(IslandCommon.no());
            target.setUpdatedTime(IslandUtil.now());
            if (result != null) {
                target.setIsMutual(IslandCommon.yes());
                result.setIsMutual(IslandCommon.yes());
                islandVisitorRelationMapper.updateByPrimaryKeySelective(result);
            }
            islandVisitorRelationMapper.updateByPrimaryKeySelective(target);
            LOGGER.info("{}重新关注了{}，是否相互关注：{}", islandVisitorRelation.getFansId(), islandVisitorRelation.getStarId(), islandVisitorRelation.getIsMutual());
            return target;
        }
    }

    @Override
    public IslandVisitorRelation cancelConcern(IslandVisitorRelation islandVisitorRelation) {
        // 检查历史记录
        IslandVisitorRelation target = islandVisitorRelationMapper.getOne(islandVisitorRelation.getFansId(), islandVisitorRelation.getStarId(), IslandCommon.no());
        if (target == null) {
            LOGGER.info("取关失败，无历史记录！");
            return null;
        } else {
            target.setIsMutual(IslandCommon.no());
            target.setUpdatedTime(IslandUtil.now());
            target.setConcernCancel(IslandCommon.yes());
            // 检查是否有相互关注
            IslandVisitorRelation result = islandVisitorRelationMapper.getOne(islandVisitorRelation.getStarId(), islandVisitorRelation.getFansId(), IslandCommon.no());
            if (result != null) {
                result.setIsMutual(IslandCommon.no());
                islandVisitorRelationMapper.updateByPrimaryKeySelective(result);
            }
            LOGGER.info("{}取关{}成功！", islandVisitorRelation.getFansId(), islandVisitorRelation.getStarId());
            islandVisitorRelationMapper.updateByPrimaryKeySelective(target);
            return target;
        }
    }

    @Override
    public IslandVisitorRelation setImportant(IslandVisitorRelation islandVisitorRelation) {
        IslandVisitorRelation target = islandVisitorRelationMapper.getOne(islandVisitorRelation.getFansId(), islandVisitorRelation.getStarId(), IslandCommon.no());
        if (target == null) {
            return null;
        }
        target.setIsImportant(IslandCommon.yes());
        islandVisitorRelationMapper.updateByPrimaryKeySelective(target);
        return target;
    }

    @Override
    public IslandVisitorRelation cancelImportant(IslandVisitorRelation islandVisitorRelation) {
        IslandVisitorRelation target = islandVisitorRelationMapper.getOne(islandVisitorRelation.getFansId(), islandVisitorRelation.getStarId(), IslandCommon.no());
        if (target == null) {
            return null;
        }
        target.setIsImportant(IslandCommon.no());
        islandVisitorRelationMapper.updateByPrimaryKeySelective(target);
        return target;
    }
}
