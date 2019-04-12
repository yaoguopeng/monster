package com.island.monster.controller;

import com.island.monster.bean.IslandMovie;
import com.island.monster.common.Response;
import com.island.monster.service.IslandMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandMovieController {

    @Autowired
    private IslandMovieService islandMovieService;

    @RequestMapping(value = "movie" ,method = RequestMethod.POST)
    public Response<IslandMovie> add(@RequestBody IslandMovie islandMovie){
        return Response.success(islandMovieService.add(islandMovie));
    }

    @RequestMapping(value = "movie/{id}" ,method = RequestMethod.DELETE)
    public Response<IslandMovie> setDel(@PathVariable("id") Integer id){
        return Response.success(islandMovieService.setDel(id));
    }

    @RequestMapping(value = "movie" ,method = RequestMethod.PUT)
    public Response<IslandMovie> edit(@RequestBody IslandMovie islandMovie){
        return Response.success(islandMovieService.edit(islandMovie));
    }

    @RequestMapping(value = "movie" ,method = RequestMethod.GET)
    public Response<IslandMovie> getOne(IslandMovie islandMovie){
        return Response.success(islandMovieService.getOne(islandMovie));
    }

    @RequestMapping(value = "movie/next/{currentId}" ,method = RequestMethod.GET)
    public Response<IslandMovie> next(@PathVariable("currentId")Integer currentId){
        return Response.success(islandMovieService.nextMovie(currentId));
    }
}
