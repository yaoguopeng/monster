package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPost;
import com.island.monster.mapper.IslandPostMapper;
import com.island.monster.service.IslandPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandPostServiceImpl implements IslandPostService {

    @Autowired
    private IslandPostMapper islandPostMapper;

    @Override
    public IslandPost getOne(String id) {
        return islandPostMapper.selectByPrimaryKey(id);
    }

    @Override
    public IslandPost setDeleted(String id) {
        islandPostMapper.setDeleted(id);
        return getOne(id);
    }

    @Override
    public List<IslandPost> getList(IslandPost islandPost) {
        return islandPostMapper.getByConditions(islandPost);
    }

    @Override
    public PageInfo<IslandPost> getPage(IslandPost islandPost, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandPost);
            }
        });
        return page;
    }
}
