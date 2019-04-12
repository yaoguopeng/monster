package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandLandscape;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandLandscapeMapper;
import com.island.monster.service.IslandLandscapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandLandscapeServiceImpl implements IslandLandscapeService {


    @Autowired
    private IslandLandscapeMapper islandLandscapeMapper;

    @Override
    public IslandLandscape randomLandscape() {
        return nextLandscape(IslandUtil.getRandomId(islandLandscapeMapper.getMaxId()));
    }

    @Override
    public IslandLandscape nextLandscape(Integer currentId) {
        IslandLandscape result = islandLandscapeMapper.nextLandscape(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandLandscapeMapper.nextLandscape(currentId);
        return result;
    }

    @Override
    public IslandLandscape getOne(IslandLandscape islandLandscape) {
        // 默认获取当前日期下的
        if (islandLandscape.getShowingDate() == null) {
            islandLandscape.setShowingDate(IslandUtil.currentDate());
        }
        List<IslandLandscape> list = getList(islandLandscape);
        if (list.isEmpty()) {
            return randomLandscape();
        }
        return list.get(0);
    }

    @Override
    public List<IslandLandscape> getList(IslandLandscape islandLandscape) {
        return islandLandscapeMapper.getByConditions(islandLandscape);
    }

    @Override
    public PageInfo<IslandLandscape> getPage(IslandLandscape islandLandscape, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandLandscape);
            }
        });
        return page;
    }
}
