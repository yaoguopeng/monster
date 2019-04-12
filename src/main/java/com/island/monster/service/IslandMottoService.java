package com.island.monster.service;

import com.island.monster.bean.IslandMotto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IslandMottoService {

    /**
     * add one motto
     *
     * @param islandMotto
     * @return
     */
    IslandMotto add(IslandMotto islandMotto);

    /**
     * delete one motto by id logically
     *
     * @param id
     * @return
     */
    IslandMotto setDel(Integer id);

    /**
     * edit motto by id
     *
     * @param islandMotto
     * @return
     */
    IslandMotto edit(IslandMotto islandMotto);

    /**
     * get the very motto by condition: showingDate
     *
     * @param islandMotto
     * @return
     */
    IslandMotto getOne(IslandMotto islandMotto);

    /**
     * get a list of motto by conditions
     *
     * @param islandMotto
     * @return
     */
    List<IslandMotto> getList(IslandMotto islandMotto);

    /**
     * get a page of motto by conditions
     *
     * @param islandMotto
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<IslandMotto> getPage(IslandMotto islandMotto, Integer pageNum, Integer pageSize);

    /**
     * get a random motto
     *
     * @return
     */
    IslandMotto randomMotto();

    IslandMotto nextMotto(Integer currentId);
}
