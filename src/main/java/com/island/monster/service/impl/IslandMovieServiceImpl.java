package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandMovie;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandMovieMapper;
import com.island.monster.service.IslandMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandMovieServiceImpl implements IslandMovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandMovieServiceImpl.class);

    @Autowired
    private IslandMovieMapper islandMovieMapper;

    @Override
    public IslandMovie getById(Integer id) {
        return islandMovieMapper.selectByPrimaryKey(id);
    }

    @Override
    public IslandMovie add(IslandMovie islandMovie) {
        islandMovie.setCreatedTime(IslandUtil.now());
        islandMovie.setUuid(IslandUtil.uuid());
        islandMovieMapper.insertSelective(islandMovie);
        return islandMovie;
    }

    @Override
    public IslandMovie setDel(Integer id) {
        islandMovieMapper.setDel(id);
        return null;
    }

    @Override
    public IslandMovie remove(Integer id) {
        islandMovieMapper.delete(id);
        return null;
    }

    @Override
    public IslandMovie edit(IslandMovie islandMovie) {
        islandMovieMapper.updateByPrimaryKeySelective(islandMovie);
        return islandMovie;
    }

    @Override
    public IslandMovie getOne(IslandMovie islandMovie) {
        // 默认获取当前日期下的
        if (islandMovie.getShowingDate() == null) {
            islandMovie.setShowingDate(IslandUtil.currentDate());
        }
        if (islandMovie.getShowingDate().getTime() > IslandUtil.currentDate().getTime()) {
            // 日期已经超过了当前日期
            LOGGER.info("获取movie指定日期【{}】超出当前日期，不予理会！", islandMovie.getShowingDate());
            return null;
        }
        List<IslandMovie> list = islandMovieMapper.getByConditions(islandMovie);
        if (list.isEmpty()) {
            return randomMovie();
        }
        return list.get(0);
    }

    @Override
    public IslandMovie nextMovie(Integer currentId) {
        IslandMovie result = islandMovieMapper.nextMovie(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandMovieMapper.nextMovie(currentId);
        return result;
    }

    @Override
    public IslandMovie randomMovie() {
        return nextMovie(IslandUtil.getRandomId(islandMovieMapper.getMaxId()));
    }

    @Override
    public List<IslandMovie> getList(IslandMovie islandMovie) {
        return islandMovieMapper.getByConditions(islandMovie);
    }

    @Override
    public PageInfo<IslandMovie> getPage(IslandMovie islandMovie, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandMovie);
            }
        });
        return page;
    }
}
