package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.*;
import com.island.monster.common.IslandCommon;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.*;
import com.island.monster.service.VisitorStorehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorStorehouseServiceImpl implements VisitorStorehouseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisitorStorehouseServiceImpl.class);

    @Autowired
    private VisitorStorehouseMapper visitorStorehouseMapper;

    @Autowired
    private IslandMottoMapper islandMottoMapper;

    @Autowired
    private IslandMovieMapper islandMovieMapper;

    @Autowired
    private IslandMusicMapper islandMusicMapper;

    @Autowired
    private IslandPaintingMapper islandPaintingMapper;

    @Autowired
    private IslandPassageMapper islandPassageMapper;

    @Autowired
    private IslandPoemMapper islandPoemMapper;

    @Autowired
    private IslandJokeMapper islandJokeMapper;

    @Autowired
    private IslandLandscapeMapper islandLandscapeMapper;


    @Override
    public VisitorStorehouse add(VisitorStorehouse visitorStorehouse) {
        if(!IslandUtil.validWorkType(visitorStorehouse.getWorkType())){ // 枚举类型不匹配
            LOGGER.info("枚举类型不匹配，所给类型："+visitorStorehouse.getWorkType());
            return null;
        }
        List<VisitorStorehouse> list = visitorStorehouseMapper.getByConditions(visitorStorehouse);
        if (list.isEmpty()) {
            visitorStorehouse.setId(IslandUtil.uuid());
            visitorStorehouse.setStoredTime(IslandUtil.now());
            visitorStorehouseMapper.insertSelective(visitorStorehouse);
        } else {
            visitorStorehouse = list.get(0);
            visitorStorehouse.setStoredTime(IslandUtil.now());
            visitorStorehouse.setStoredCancel(IslandCommon.activeStatus());
            visitorStorehouseMapper.updateByPrimaryKeySelective(visitorStorehouse);
        }
        return visitorStorehouse;
    }

    @Override
    public VisitorStorehouse cancel(String id) {
        VisitorStorehouse target = new VisitorStorehouse();
        target.setId(id);
        target.setCancelTime(IslandUtil.now());
        target.setStoredCancel(IslandCommon.deletedStatus());
        if (visitorStorehouseMapper.updateByPrimaryKeySelective(target) != 1) {
            return null;
        }
        return target;
    }

    @Override
    public List<?> onesFavorite(String unionId, IslandCommon.WorkType workType) {
        switch (workType) {
            case PAINTING: {
                return onesFavoritePainting(unionId);
            }
            case PASSAGE: {
                return onesFavoritePassage(unionId);
            }
            case MUSIC: {
                return onesFavoriteMusic(unionId);
            }
            case MOTTO: {
                return onesFavoriteMotto(unionId);
            }
            case POEM: {
                return onesFavoritePoem(unionId);
            }
            case JOKE: {
                return onesFavoriteJoke(unionId);
            }
            case MOVIE: {
                return onesFavoriteMovie(unionId);
            }
            case LANDSCAPE: {
                return onesFavoriteLandscape(unionId);
            }
        }
        return null;
    }

    @Override
    public PageInfo<?> onesFavorite(String unionId, IslandCommon.WorkType workType, Integer pageSize, Integer pageNum) {
        switch (workType) {
            case PAINTING: {
                return onesFavoritePainting(unionId, pageSize, pageNum);
            }
            case PASSAGE: {
                return onesFavoritePassage(unionId, pageSize, pageNum);
            }
            case MUSIC: {
                return onesFavoriteMusic(unionId, pageSize, pageNum);
            }
            case MOTTO: {
                return onesFavoriteMotto(unionId, pageSize, pageNum);
            }
            case POEM: {
                return onesFavoritePoem(unionId, pageSize, pageNum);
            }
            case JOKE: {
                return onesFavoriteJoke(unionId, pageSize, pageNum);
            }
            case MOVIE: {
                return onesFavoriteMovie(unionId, pageSize, pageNum);
            }
            case LANDSCAPE: {
                return onesFavoriteLandscape(unionId, pageSize, pageNum);
            }
        }
        return null;
    }

    @Override
    public List<VisitorStorehouse> getList(VisitorStorehouse visitorStorehouse) {
        return visitorStorehouseMapper.getByConditions(visitorStorehouse);
    }

    @Override
    public PageInfo<VisitorStorehouse> getPage(VisitorStorehouse visitorStorehouse, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(visitorStorehouse);
            }
        });
        return page;
    }

    @Override
    public List<IslandJoke> onesFavoriteJoke(String unionId) {
        return islandJokeMapper.onesFavorite(unionId);
    }

    @Override
    public List<IslandMotto> onesFavoriteMotto(String unionId) {
        return islandMottoMapper.onesFavorite(unionId);
    }

    @Override
    public List<IslandMovie> onesFavoriteMovie(String unionId) {
        return islandMovieMapper.onesFavorite(unionId);
    }

    @Override
    public List<IslandMusic> onesFavoriteMusic(String unionId) {
        return islandMusicMapper.onesFavorite(unionId);
    }

    @Override
    public List<IslandPainting> onesFavoritePainting(String unionId) {
        return islandPaintingMapper.onesFavorite(unionId);
    }

    @Override
    public List<IslandPassage> onesFavoritePassage(String unionId) {
        return islandPassageMapper.onesFavorite(unionId);
    }

    @Override
    public List<IslandPoem> onesFavoritePoem(String unionId) {
        return islandPoemMapper.onesFavorite(unionId);
    }

    @Override
    public List<IslandLandscape> onesFavoriteLandscape(String unionId) {
        return islandLandscapeMapper.onesFavorite(unionId);
    }

    @Override
    public PageInfo<IslandJoke> onesFavoriteJoke(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandJokeMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

    @Override
    public PageInfo<IslandMotto> onesFavoriteMotto(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandMottoMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

    @Override
    public PageInfo<IslandMovie> onesFavoriteMovie(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandMovieMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

    @Override
    public PageInfo<IslandMusic> onesFavoriteMusic(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandMusicMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

    @Override
    public PageInfo<IslandPainting> onesFavoritePainting(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandPaintingMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

    @Override
    public PageInfo<IslandPassage> onesFavoritePassage(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandPassageMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

    @Override
    public PageInfo<IslandPoem> onesFavoritePoem(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandPoemMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

    @Override
    public PageInfo<IslandLandscape> onesFavoriteLandscape(String unionId, Integer pageSize, Integer pageNum) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                islandLandscapeMapper.onesFavorite(unionId);
            }
        });
        return page;
    }

}
