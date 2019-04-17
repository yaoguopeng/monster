package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPostReply;

import java.util.List;

public interface IslandPostReplyService {

    IslandPostReply add(IslandPostReply islandPostReply);

    IslandPostReply setDeleted(String id);

    IslandPostReply edit(IslandPostReply islandPostReply);

    IslandPostReply getOne(String id);

    List<IslandPostReply> getList(IslandPostReply islandPostReply);

    PageInfo<IslandPostReply> getPage(IslandPostReply islandPostReply, Integer pageNum, Integer pageSize);
}
