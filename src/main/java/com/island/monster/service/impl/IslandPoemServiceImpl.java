package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.common.IslandCommon;
import com.island.monster.bean.IslandPoem;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandPoemMapper;
import com.island.monster.service.IslandPoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandPoemServiceImpl implements IslandPoemService {

    @Autowired
    private IslandPoemMapper islandPoemMapper;

    @Override
    public IslandPoem add(IslandPoem islandPoem) {
        islandPoem.setCreatedTime(IslandUtil.now());
        islandPoemMapper.insertSelective(islandPoem);
        return islandPoem;
    }

    @Override
    public IslandPoem remove(Integer id) {
        islandPoemMapper.delete(id);
        return null;
    }

    @Override
    public IslandPoem setDel(Integer id) {
        IslandPoem target = islandPoemMapper.selectByPrimaryKey(id);
        if (target == null) {
            return null;
        }
        target.setIsDeleted(IslandCommon.deletedStatus());
        islandPoemMapper.updateByPrimaryKeySelective(target);
        return target;
    }

    @Override
    public IslandPoem edit(IslandPoem islandPoem) {
        islandPoemMapper.updateByPrimaryKeySelective(islandPoem);
        return islandPoem;
    }

    @Override
    public IslandPoem getOne(IslandPoem islandPoem) {
        // 默认获取当前日期下的
        if (islandPoem.getShowingDate() == null) {
            islandPoem.setShowingDate(IslandUtil.currentDate());
        }
        List<IslandPoem> list = islandPoemMapper.getByConditions(islandPoem);
        if (list.isEmpty()) {
            return randomPoem();
        }
        return list.get(0);
    }

    @Override
    public IslandPoem nextPoem(Integer currentId) {
        IslandPoem result = islandPoemMapper.nextPoem(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandPoemMapper.nextPoem(currentId);
        return result;
    }

    @Override
    public IslandPoem randomPoem() {
        return nextPoem(IslandUtil.getRandomId(islandPoemMapper.getMaxId()));
    }

    @Override
    public List<IslandPoem> getList(IslandPoem islandPoem) {
        return islandPoemMapper.getByConditions(islandPoem);
    }

    @Override
    public PageInfo<IslandPoem> getPage(IslandPoem islandPoem, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandPoem);
            }
        });
        return page;
    }
}

