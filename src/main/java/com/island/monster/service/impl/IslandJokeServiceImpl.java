package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandJoke;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandJokeMapper;
import com.island.monster.service.IslandJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandJokeServiceImpl implements IslandJokeService {

    @Autowired
    private IslandJokeMapper islandJokeMapper;

    @Override
    public IslandJoke randomJoke() {
        return nextJoke(IslandUtil.getRandomId(islandJokeMapper.getMaxId()));
    }

    @Override
    public IslandJoke nextJoke(Integer currentId) {
        IslandJoke result = islandJokeMapper.nextJoke(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandJokeMapper.nextJoke(currentId);
        return result;
    }

    @Override
    public IslandJoke add(IslandJoke islandJoke) {
        islandJoke.setUuid(IslandUtil.uuid());
        islandJoke.setCreatedTime(IslandUtil.now());
        islandJokeMapper.insertSelective(islandJoke);
        return islandJoke;
    }

    @Override
    public IslandJoke edit(IslandJoke islandJoke) {
        islandJokeMapper.updateSelective(islandJoke);
        return islandJoke;
    }

    @Override
    public List<IslandJoke> getList(IslandJoke islandJoke) {
        return islandJokeMapper.getByConditions(islandJoke);
    }

    @Override
    public PageInfo<IslandJoke> getPage(IslandJoke islandJoke, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandJoke);
            }
        });
        return page;
    }


}
