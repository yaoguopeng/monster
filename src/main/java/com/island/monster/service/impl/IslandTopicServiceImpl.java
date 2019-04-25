package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandTopic;
import com.island.monster.bean.IslandTopicInfo;
import com.island.monster.common.IslandCommon;
import com.island.monster.common.IslandUtil;
import com.island.monster.highConcurrency.IslandActorService;
import com.island.monster.mapper.IslandTopicMapper;
import com.island.monster.service.IslandTopicInfoService;
import com.island.monster.service.IslandTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class IslandTopicServiceImpl implements IslandTopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandTopicServiceImpl.class);

    @Autowired
    private IslandTopicMapper islandTopicMapper;

    @Autowired
    private IslandTopicInfoService islandTopicInfoService;

    @Autowired
    private IslandActorService islandActorService;

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
        islandTopicMapper.insertSelective(islandTopic);
        islandTopicInfoService.add(topicId);
        LOGGER.info("新增主题成功，主题名称：{}，创建人：{}", islandTopic.getTopicName(), islandTopic.getCreatedBy());
        return islandTopic;
    }

    @Override
    public IslandTopic setDeleted(String id) {
        islandTopicMapper.setDeleted(id);
        return islandTopicMapper.selectByPrimaryKey(id);
    }

    private IslandTopic topicVisited(IslandTopic islandTopic) {
        if(islandTopic==null){
            return null;
        }
        islandActorService.topicVisited(islandTopic);
        return islandTopic;
    }

    private List<IslandTopic> topicVisited(List<IslandTopic> islandTopics) {
        ExecutorService pool = Executors.newFixedThreadPool(islandTopics.size());
        CountDownLatch latch = new CountDownLatch(islandTopics.size());
        for (IslandTopic islandTopic : islandTopics) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    topicVisited(islandTopic);
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        return islandTopics;
    }

    @Override
    public IslandTopic getByTopicName(String topicName) {
        // 新增访量
        return topicVisited(islandTopicMapper.selectByTopicName(topicName));
    }

    @Override
    public IslandTopic getOne(String id) {
        // 新增访量
        return topicVisited(islandTopicMapper.selectByPrimaryKey(id));
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

    @Override
    public List<IslandTopic> onesFavoriteTopic(String unionId) {
        return islandTopicMapper.onesFavoriteTopic(unionId);
    }

    @Override
    public PageInfo<IslandTopic> onesFavoriteTopic(String unionId, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                onesFavoriteTopic(unionId);
            }
        });
        return page;
    }
}
