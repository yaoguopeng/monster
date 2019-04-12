package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.common.IslandCommon;
import com.island.monster.bean.IslandMusic;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandMusicMapper;
import com.island.monster.service.IslandMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandMusicServiceImpl implements IslandMusicService {

    @Autowired
    private IslandMusicMapper islandMusicMapper;

    @Override
    public IslandMusic getOne(IslandMusic islandMusic) {
        // 默认获取当前日期下的
        if (islandMusic.getShowingDate() == null) {
            islandMusic.setShowingDate(IslandUtil.currentDate());
        }
        List<IslandMusic> list = islandMusicMapper.getByConditions(islandMusic);
        if (list.isEmpty()) {
            return randomMusic();
        }
        return list.get(0);
    }

    @Override
    public IslandMusic nextMusic(Integer currentId) {
        IslandMusic result = islandMusicMapper.nextMusic(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandMusicMapper.nextMusic(currentId);
        return result;
    }

    @Override
    public IslandMusic randomMusic() {
        return nextMusic(IslandUtil.getRandomId(islandMusicMapper.getMaxId()));
    }

    @Override
    public IslandMusic add(IslandMusic islandMusic) {
        islandMusic.setUuid(IslandUtil.uuid());
        islandMusic.setCreatedTime(IslandUtil.now());
        islandMusicMapper.insertSelective(islandMusic);
        return islandMusic;
    }

    @Override
    public IslandMusic edit(IslandMusic islandMusic) {
        if (islandMusicMapper.selectByPrimaryKey(islandMusic.getId()) == null) {
            return null;
        }
        islandMusicMapper.updateByPrimaryKeySelective(islandMusic);
        return islandMusic;
    }

    @Override
    public IslandMusic remove(Integer id) {
        IslandMusic islandMusic = islandMusicMapper.selectByPrimaryKey(id);
        islandMusicMapper.delete(id);
        return islandMusic;
    }

    @Override
    public IslandMusic setDel(Integer id) {
        IslandMusic target = islandMusicMapper.selectByPrimaryKey(id);
        if (target == null) {
            return null;
        }
        target.setIsDeleted(IslandCommon.deletedStatus());
        return target;
    }

    @Override
    public List<IslandMusic> getList(IslandMusic islandMusic) {
        return islandMusicMapper.getByConditions(islandMusic);
    }

    @Override
    public PageInfo<IslandMusic> getPage(IslandMusic islandMusic, Integer pageNum, Integer pageSize) {
        PageInfo<IslandMusic> page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandMusic);
            }
        });
        return page;
    }
}
