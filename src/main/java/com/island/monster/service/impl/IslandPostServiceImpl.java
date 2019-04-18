package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPost;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandPostMapper;
import com.island.monster.mapper.IslandPostReplyMapper;
import com.island.monster.mapper.IslandPostThumbsUpMapper;
import com.island.monster.service.IslandPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IslandPostServiceImpl implements IslandPostService {

    @Autowired
    private IslandPostMapper islandPostMapper;

    @Autowired
    private IslandPostReplyMapper islandPostReplyMapper;

    @Autowired
    private IslandPostThumbsUpMapper islandPostThumbsUpMapper;

    @Override
    public IslandPost getOne(String id) {
        return islandPostMapper.selectByPrimaryKey(id);
    }

    @Override
    public IslandPost update(IslandPost islandPost) {
        if (getOne(islandPost.getId()) == null) {
            islandPost.setCreatedTime(IslandUtil.now());
            islandPostMapper.insertSelective(islandPost);
        } else {
            islandPost.setUpdatedTime(IslandUtil.now());
            islandPostMapper.updateByPrimaryKeySelective(islandPost);
        }
        return islandPost;
    }

    @Override
    public IslandPost setDeleted(String id) {
        islandPostMapper.setDeleted(id);
        return getOne(id);
    }

    @Transactional
    @Override
    public IslandPost remove(String id) {
        IslandPost target = getOne(id);
        // 级联删除其下的回复以及点赞信息
        islandPostMapper.remove(id);
        islandPostReplyMapper.removeByPostId(id);
        islandPostThumbsUpMapper.removeByPostId(id);
        return target;
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

    @Override
    public List<IslandPost> onesStarsPosts(String unionId) {
        return null;
    }

    @Override
    public PageInfo<IslandPost> onesStarsPosts(String unionId, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<IslandPost> onesFavoriteTopicPosts(String unionId) {
        return null;
    }

    @Override
    public PageInfo<IslandPost> onesFavoriteTopicPosts(String unionId, Integer pageNum, Integer pageSize) {
        return null;
    }
}
