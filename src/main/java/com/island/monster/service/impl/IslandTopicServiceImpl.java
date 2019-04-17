package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandTopic;
import com.island.monster.bean.IslandTopicInfo;
import com.island.monster.common.IslandCommon;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandTopicMapper;
import com.island.monster.service.IslandTopicInfoService;
import com.island.monster.service.IslandTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IslandTopicServiceImpl implements IslandTopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandTopicServiceImpl.class);

    @Autowired
    private IslandTopicMapper islandTopicMapper;

    @Autowired
    private IslandTopicInfoService islandTopicInfoService;

    @Transactional
    @Override
    public IslandTopic add(IslandTopic islandTopic) {
        // 检验是否已经存在同名主题
        IslandTopic result = getByTopicName(islandTopic.getTopicName());
        if (result != null) {
            LOGGER.info("新增主题失败，已经存在同名主题：{}", islandTopic.getTopicName());
            return result;
        }
        // 新建主题入库：主题表以及主题信息表
        String topicId = IslandUtil.uuid();
        islandTopic.setId(topicId);
        if (islandTopic.getTopicType() == null) {
            islandTopic.setTopicType(IslandCommon.TopicType.NONE);
        }
        islandTopic.setCreatedTime(IslandUtil.now());
        IslandTopicInfo islandTopicInfo = new IslandTopicInfo();
        islandTopicInfo.setTopicId(topicId);
        islandTopicMapper.insertSelective(islandTopic);
        islandTopicInfoService.add(islandTopicInfo);
        return islandTopic;
    }

    @Override
    public IslandTopic setDeleted(String id) {
        islandTopicMapper.setDeleted(id);
        return islandTopicMapper.selectByPrimaryKey(id);
    }

    @Override
    public IslandTopic getByTopicName(String topicName) {
        return islandTopicMapper.selectByTopicName(topicName);
    }

    @Override
    public IslandTopic getOne(String id) {
        return islandTopicMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<IslandTopic> getList(IslandTopic islandTopic) {
        return islandTopicMapper.getByConditions(islandTopic);
    }

    @Override
    public PageInfo<IslandTopic> getPage(IslandTopic islandTopic, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandTopic);
            }
        });
        return page;
    }
}
