package com.island.monster.service;

import com.island.monster.bean.IslandVisitor;

public interface IslandVisitorService {

    IslandVisitor update(IslandVisitor islandVisitor);

    IslandVisitor getByUnionId(String unionId);
}
