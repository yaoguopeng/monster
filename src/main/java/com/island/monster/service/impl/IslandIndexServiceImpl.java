package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandIndex;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandIndexMapper;
import com.island.monster.service.IslandIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandIndexServiceImpl implements IslandIndexService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandIndexServiceImpl.class);

    @Autowired
    private IslandIndexMapper islandIndexMapper;

    @Override
    public IslandIndex randomIndex() {
        return nextIndex(IslandUtil.getRandomId(islandIndexMapper.getMaxId()));
    }

    @Override
    public IslandIndex getById(Integer id) {
        return islandIndexMapper.selectByPrimaryKey(id);
    }

    @Override
    public IslandIndex nextIndex(Integer currentId) {
        IslandIndex result = islandIndexMapper.nextIndex(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandIndexMapper.nextIndex(currentId);
        return result;
    }

    @Override
    public IslandIndex getOne(IslandIndex islandIndex) {
        // 默认获取当前日期下的
        if (islandIndex.getShowingDate() == null) {
            islandIndex.setShowingDate(IslandUtil.currentDate());
        }
        if (islandIndex.getShowingDate().getTime() > IslandUtil.currentDate().getTime()) {
            // 日期已经超过了当前日期
            LOGGER.info("获取index指定日期【{}】超出当前日期，不予理会！", islandIndex.getShowingDate());
            return null;
        }
        List<IslandIndex> list = getList(islandIndex);
        if (list.isEmpty()) {
            return randomIndex();
        }
        return list.get(0);
    }

    @Override
    public List<IslandIndex> getList(IslandIndex islandIndex) {
        return islandIndexMapper.getByConditions(islandIndex);
    }

    @Override
    public PageInfo<IslandIndex> getPage(IslandIndex islandIndex, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandIndex);
            }
        });
        return page;
    }
}
