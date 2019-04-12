package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPainting;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandPaintingMapper;
import com.island.monster.service.IslandPaintingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandPaintingServiceImpl implements IslandPaintingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandPaintingServiceImpl.class);

    @Autowired
    private IslandPaintingMapper islandPaintingMapper;

    @Override
    public IslandPainting add(IslandPainting islandPainting) {
        islandPainting.setUuid(IslandUtil.uuid());
        islandPainting.setCreatedTime(IslandUtil.now());
        islandPaintingMapper.insertSelective(islandPainting);
        return islandPainting;
    }

    @Override
    public IslandPainting remove(Integer id) {
        islandPaintingMapper.delete(id);
        return null;
    }

    @Override
    public IslandPainting setDel(Integer id) {
        islandPaintingMapper.setDel(id);
        return islandPaintingMapper.selectByPrimaryKey(id);
    }

    @Override
    public IslandPainting edit(IslandPainting islandPainting) {
        islandPaintingMapper.updateByPrimaryKeySelective(islandPainting);
        return islandPainting;
    }

    @Override
    public IslandPainting getOne(IslandPainting islandPainting) {
        // 默认获取当前日期下的
        if (islandPainting.getShowingDate() == null) {
            islandPainting.setShowingDate(IslandUtil.currentDate());
        }
        List<IslandPainting> list = islandPaintingMapper.getByConditions(islandPainting);
        if (list.isEmpty()) {
            return randomPainting();
        }
        return list.get(0);
    }

    @Override
    public IslandPainting nextPainting(Integer currentId) {
        IslandPainting result = islandPaintingMapper.nextPainting(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandPaintingMapper.nextPainting(currentId);
        return result;
    }

    @Override
    public IslandPainting randomPainting() {
        return nextPainting(IslandUtil.getRandomId(islandPaintingMapper.getMaxId()));
    }

    @Override
    public List<IslandPainting> getList(IslandPainting islandPainting) {
        return islandPaintingMapper.getByConditions(islandPainting);
    }

    @Override
    public PageInfo<IslandPainting> getPage(IslandPainting islandPainting, Integer pageNum, Integer pageSize) {
        PageInfo<IslandPainting> pages = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandPaintingMapper.getByConditions(islandPainting);
            }
        });
        return pages;
    }
}
