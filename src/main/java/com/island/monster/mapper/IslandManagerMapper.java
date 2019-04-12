package com.island.monster.mapper;

import com.island.monster.bean.IslandManager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IslandManagerMapper {

    /**
     * conditions are realName/registeName/bindEmail
     *
     * @param islandManager
     * @return
     */
    List<IslandManager> getByConditions(IslandManager islandManager);

    /**
     * insert a record into table t_island_manager
     *
     * @param islandManager
     * @return
     */
    int insertSelective(IslandManager islandManager);

    /**
     * get information of a manager from table t_island_manager by id
     *
     * @param id
     * @return
     */
    IslandManager selectByPrimaryKey(String id);

    /**
     * update table t_island_manager selective
     *
     * @param islandManager
     * @return
     */
    int updateByPrimaryKeySelective(IslandManager islandManager);

    /**
     * remove record of a manager with the provide id
     *
     * @param id
     * @return
     */
    int delete(String id);
}
