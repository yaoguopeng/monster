package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPassage;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandPassageMapper;
import com.island.monster.service.IslandPassageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandPassageServiceImpl implements IslandPassageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandPassageServiceImpl.class);

    @Autowired
    private IslandPassageMapper islandPassageMapper;

    @Override
    public IslandPassage add(IslandPassage islandPassage) {
        islandPassage.setCreatedTime(IslandUtil.now());
        islandPassageMapper.insertSelective(islandPassage);
        return islandPassage;
    }

    @Override
    public IslandPassage remove(Integer id) {
        islandPassageMapper.delete(id);
        return null;
    }

    @Override
    public IslandPassage setDel(Integer id) {
        islandPassageMapper.setDel(id);
        return islandPassageMapper.selectByPrimaryKey(id);
    }

    @Override
    public IslandPassage edit(IslandPassage islandPassage) {
        islandPassageMapper.updateByPrimaryKeySelective(islandPassage);
        return islandPassage;
    }

    @Override
    public IslandPassage getOne(IslandPassage islandPassage) {
        // 默认获取当前日期下的
        if (islandPassage.getShowingDate() == null) {
            islandPassage.setShowingDate(IslandUtil.currentDate());
        }
        if (islandPassage.getShowingDate().getTime() > IslandUtil.currentDate().getTime()) {
            // 日期已经超过了当前日期
            LOGGER.info("获取passage指定日期【{}】超出当前日期，不予理会！", islandPassage.getShowingDate());
            return null;
        }
        List<IslandPassage> list = islandPassageMapper.getByConditions(islandPassage);
        if (list.isEmpty()) {
            return randomPassage();
        }
        return list.get(0);
    }

    @Override
    public IslandPassage nextPassage(Integer currentId) {
        IslandPassage result = islandPassageMapper.nextPassage(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandPassageMapper.nextPassage(currentId);
        return result;
    }

    @Override
    public IslandPassage randomPassage() {
        return nextPassage(IslandUtil.getRandomId(islandPassageMapper.getMaxId()));
    }

    @Override
    public List<IslandPassage> getList(IslandPassage islandPassage) {
        return islandPassageMapper.getByConditions(islandPassage);
    }

    @Override
    public PageInfo<IslandPassage> getPage(IslandPassage islandPassage, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandPassage);
            }
        });
        return page;
    }
}
