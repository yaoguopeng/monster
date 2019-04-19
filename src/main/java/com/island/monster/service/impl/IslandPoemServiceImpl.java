package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.common.IslandCommon;
import com.island.monster.bean.IslandPoem;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandPoemMapper;
import com.island.monster.service.IslandPoemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandPoemServiceImpl implements IslandPoemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandPoemServiceImpl.class);

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
        target.setIsDeleted(IslandCommon.yes());
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
        if (islandPoem.getShowingDate().getTime() > IslandUtil.currentDate().getTime()) {
            // 日期已经超过了当前日期
            LOGGER.info("获取poem指定日期【{}】超出当前日期，不予理会！", islandPoem.getShowingDate());
            return null;
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

