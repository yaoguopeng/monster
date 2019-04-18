package com.island.monster.service;

import com.island.monster.bean.IslandVisitorRelation;

public interface IslandVisitorRelationService {

    /**
     * add a new one or change the exits one's concernCancel from yes to no
     * check isMutual by the way , fansId and starId is need
     *
     * @param islandVisitorRelation
     * @return
     */
    IslandVisitorRelation addConcern(IslandVisitorRelation islandVisitorRelation);

    /**
     * just set cancelConcern yes and update the updateTime
     * check isMutual by the way
     *
     * @param islandVisitorRelation
     * @return
     */
    IslandVisitorRelation cancelConcern(IslandVisitorRelation islandVisitorRelation);

    /**
     * just set isImportant to be yes , fansId and starId is need
     *
     * @param islandVisitorRelation
     * @return
     */
    IslandVisitorRelation setImportant(IslandVisitorRelation islandVisitorRelation);

    /**
     * just set isImportant to be no , fansId and starId is need
     *
     * @param islandVisitorRelation
     * @return
     */
    IslandVisitorRelation cancelImportant(IslandVisitorRelation islandVisitorRelation);
}
