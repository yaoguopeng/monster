package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.common.IslandCommon;
import com.island.monster.bean.IslandMotto;
import com.island.monster.common.IslandUtil;
import com.island.monster.mapper.IslandMottoMapper;
import com.island.monster.service.IslandMottoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandMottoServiceImpl implements IslandMottoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandMottoServiceImpl.class);

    @Autowired
    private IslandMottoMapper islandMottoMapper;

    @Override
    public IslandMotto add(IslandMotto islandMotto) {
        // use current time as motto created time
        islandMotto.setCreatedTime(IslandUtil.now());
        islandMottoMapper.insertSelective(islandMotto);
        return islandMotto;
    }

    @Override
    public IslandMotto setDel(Integer id) {
        IslandMotto target = islandMottoMapper.selectByPrimaryKey(id);
        if (target == null) {
            return null;
        }
        target.setIsDeleted(IslandCommon.yes());
        islandMottoMapper.updateByPrimaryKeySelective(target);
        return target;
    }

    @Override
    public IslandMotto edit(IslandMotto islandMotto) {
        islandMottoMapper.updateByPrimaryKeySelective(islandMotto);
        return islandMotto;
    }

    @Override
    public IslandMotto getOne(IslandMotto islandMotto) {
        // 默认获取当前日期下的
        if (islandMotto.getShowingDate() == null) {
            islandMotto.setShowingDate(IslandUtil.currentDate());
        }
        if (islandMotto.getShowingDate().getTime() > IslandUtil.currentDate().getTime()) {
            // 日期已经超过了当前日期
            LOGGER.info("获取motto指定日期【{}】超出当前日期，不予理会！", islandMotto.getShowingDate());
            return null;
        }
        List<IslandMotto> list = islandMottoMapper.getByConditions(islandMotto);
        if (list.isEmpty()) {
            return randomMotto();
        }
        return list.get(0);
    }

    @Override
    public List<IslandMotto> getList(IslandMotto islandMotto) {
        return islandMottoMapper.getByConditions(islandMotto);
    }

    @Override
    public PageInfo<IslandMotto> getPage(IslandMotto islandMotto, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandMotto);
            }
        });
        return page;
    }

    @Override
    public IslandMotto randomMotto() {
        return nextMotto(IslandUtil.getRandomId(islandMottoMapper.getMaxId()));
    }

    @Override
    public IslandMotto nextMotto(Integer currentId) {
        IslandMotto result = islandMottoMapper.nextMotto(currentId);
        if (result == null) {
            currentId = 0;
        }
        result = islandMottoMapper.nextMotto(currentId);
        return result;
    }
}
