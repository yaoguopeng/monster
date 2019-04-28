package com.island.monster.service;

import com.island.monster.bean.IslandVisitLog;
import com.island.monster.common.IslandCommon;

public interface IslandVisitLogService {

    IslandVisitLog addOne(String unionId, String visitObjectId, IslandCommon.VisitObjectType visitObjectType);

}
