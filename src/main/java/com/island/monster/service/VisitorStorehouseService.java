package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.*;
import com.island.monster.common.IslandCommon;

import java.util.List;

public interface VisitorStorehouseService {

    VisitorStorehouse add(VisitorStorehouse visitorStorehouse);

    VisitorStorehouse cancel(String id);

    List<?> onesFavorite(String unionId, IslandCommon.WorkType workType);

    PageInfo<?> onesFavorite(String unionId, IslandCommon.WorkType workType, Integer pageSize, Integer pageNum);

    List<VisitorStorehouse> getList(VisitorStorehouse visitorStorehouse);

    PageInfo<VisitorStorehouse> getPage(VisitorStorehouse visitorStorehouse, Integer pageSize, Integer pageNum);

    List<IslandJoke> onesFavoriteJoke(String unionId);

    List<IslandMotto> onesFavoriteMotto(String unionId);

    List<IslandMovie> onesFavoriteMovie(String unionId);

    List<IslandMusic> onesFavoriteMusic(String unionId);

    List<IslandPainting> onesFavoritePainting(String unionId);

    List<IslandPassage> onesFavoritePassage(String unionId);

    List<IslandPoem> onesFavoritePoem(String unionId);

    List<IslandLandscape> onesFavoriteLandscape(String unionId);

    PageInfo<IslandJoke> onesFavoriteJoke(String unionId, Integer pageSize, Integer pageNum);

    PageInfo<IslandMotto> onesFavoriteMotto(String unionId, Integer pageSize, Integer pageNum);

    PageInfo<IslandMovie> onesFavoriteMovie(String unionId, Integer pageSize, Integer pageNum);

    PageInfo<IslandMusic> onesFavoriteMusic(String unionId, Integer pageSize, Integer pageNum);

    PageInfo<IslandPainting> onesFavoritePainting(String unionId, Integer pageSize, Integer pageNum);

    PageInfo<IslandPassage> onesFavoritePassage(String unionId, Integer pageSize, Integer pageNum);

    PageInfo<IslandPoem> onesFavoritePoem(String unionId, Integer pageSize, Integer pageNum);

    PageInfo<IslandLandscape> onesFavoriteLandscape(String unionId, Integer pageSize, Integer pageNum);
}
