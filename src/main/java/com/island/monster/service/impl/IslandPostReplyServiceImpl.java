package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPostReply;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandPostReplyMapper;
import com.island.monster.service.IslandPostReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandPostReplyServiceImpl implements IslandPostReplyService {

    @Autowired
    private IslandPostReplyMapper islandPostReplyMapper;

    @Override
    public IslandPostReply add(IslandPostReply islandPostReply) {
        islandPostReply.setId(IslandUtil.uuid());
        islandPostReply.setCreatedTime(IslandUtil.now());
        islandPostReplyMapper.insertSelective(islandPostReply);
        return islandPostReply;
    }

    @Override
    public IslandPostReply setDeleted(String id) {
        islandPostReplyMapper.setDeleted(id);
        return getOne(id);
    }

    @Override
    public IslandPostReply edit(IslandPostReply islandPostReply) {
        islandPostReply.setUpdatedTime(IslandUtil.now());
        islandPostReplyMapper.updateByPrimaryKeySelective(islandPostReply);
        return islandPostReply;
    }

    @Override
    public IslandPostReply getOne(String id) {
        return islandPostReplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<IslandPostReply> getList(IslandPostReply islandPostReply) {
        return islandPostReplyMapper.getByConditions(islandPostReply);
    }

    @Override
    public PageInfo<IslandPostReply> getPage(IslandPostReply islandPostReply, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandPostReply);
            }
        });
        return page;
    }
}
