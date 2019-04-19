package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandBackground;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandBackgroundMapper;
import com.island.monster.service.IslandBackgroundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandBackgroundServiceImpl implements IslandBackgroundService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandBackgroundServiceImpl.class);

    @Autowired
    private IslandBackgroundMapper islandBackgroundMapper;

    @Override
    public IslandBackground randomBackground() {
        return nextBackground(IslandUtil.getRandomId(islandBackgroundMapper.getMaxId()));
    }

    @Override
    public IslandBackground nextBackground(Integer currentId) {
        IslandBackground result = islandBackgroundMapper.nextBackground(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandBackgroundMapper.nextBackground(currentId);
        return result;
    }

    @Override
    public IslandBackground getOne(IslandBackground islandBackground) {
        // 先获取指定日期的背景
        if (islandBackground.getShowingDate() == null) {
            islandBackground.setShowingDate(IslandUtil.currentDate());
        }
        if (islandBackground.getShowingDate().getTime() > IslandUtil.currentDate().getTime()) {
            // 日期已经超过了当前日期
            LOGGER.info("获取background指定日期【{}】超出当前日期，不予理会！", islandBackground.getShowingDate());
            return null;
        }
        List<IslandBackground> list = getList(islandBackground);
        if (list.isEmpty()) {
            // 若无指定日期的背景，则获取相同类型的
            islandBackground.setShowingDate(null);
            list = getList(islandBackground);
            if (list.isEmpty()) {
                // 若无同类型，则随机获取一个
                return randomBackground();
            }
        }
        return list.get(0);
    }

    @Override
    public List<IslandBackground> getList(IslandBackground islandBackground) {
        return islandBackgroundMapper.getByConditions(islandBackground);
    }

    @Override
    public PageInfo<IslandBackground> getPage(IslandBackground islandBackground, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandBackground);
            }
        });
        return page;
    }
}
