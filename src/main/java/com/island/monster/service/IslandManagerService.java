package com.island.monster.service;

import com.island.monster.bean.IslandManager;

public interface IslandManagerService {

    /**
     * update the information of a manager after check the checkCode
     *
     * @param islandManager
     * @return
     */
    IslandManager edit(IslandManager islandManager);

    /**
     * check the information of a login manager
     *
     * @param islandManager
     * @return
     */
    Boolean login(IslandManager islandManager);

    /**
     * add a new manager
     *
     * @param islandManager
     * @return
     */
    IslandManager add(IslandManager islandManager);

    /**
     * get information of manager by id
     *
     * @param id
     * @return
     */
    IslandManager getOne(String id);
}
