package com.island.monster.service;

import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandMovie;

import java.util.List;

public interface IslandMovieService {

    IslandMovie add(IslandMovie islandMovie);

    IslandMovie setDel(Integer id);

    IslandMovie remove(Integer id);

    IslandMovie edit(IslandMovie islandMovie);

    IslandMovie getOne(IslandMovie islandMovie);

    IslandMovie nextMovie(Integer currentId);

    IslandMovie randomMovie();

    List<IslandMovie> getList(IslandMovie islandMovie);

    PageInfo<IslandMovie> getPage(IslandMovie islandMovie, Integer pageNum, Integer pageSize);


}
