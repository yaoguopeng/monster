package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandIndex;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandIndexMapper;
import com.island.monster.service.IslandIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandIndexServiceImpl implements IslandIndexService {

    @Autowired
    private IslandIndexMapper islandIndexMapper;

    @Override
    public IslandIndex randomIndex() {
        return nextIndex(IslandUtil.getRandomId(islandIndexMapper.getMaxId()));
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
