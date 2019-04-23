package com.island.monster.controller;

import com.island.monster.bean.IslandMusic;
import com.island.monster.common.Response;
import com.island.monster.service.IslandMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandMusicController {

    @Autowired
    private IslandMusicService islandMusicService;

    @RequestMapping(value = "music/id/{id}", method = RequestMethod.GET)
    public Response<IslandMusic> getById(@PathVariable("id") Integer id) {
        return Response.success(islandMusicService.getById(id));
    }

    @RequestMapping(value = "music/remove/{id}", method = RequestMethod.DELETE)
    public Response<IslandMusic> delete(@PathVariable("id") Integer id) {
        return Response.success(islandMusicService.remove(id));
    }

    @RequestMapping(value = "music/{id}", method = RequestMethod.DELETE)
    public Response<IslandMusic> setDel(@PathVariable("id") Integer id) {
        return Response.success(islandMusicService.setDel(id));
    }

    @RequestMapping(value = "music", method = RequestMethod.GET)
    public Response<IslandMusic> getOne(IslandMusic islandMusic) {
        return Response.success(islandMusicService.getOne(islandMusic));
    }

    @RequestMapping(value = "music/next/{currentId}", method = RequestMethod.GET)
    public Response<IslandMusic> next(@PathVariable("currentId") Integer currentId) {
        return Response.success(islandMusicService.nextMusic(currentId));
    }

    @RequestMapping(value = "musics", method = RequestMethod.GET)
    public Response<?> get(IslandMusic islandMusic, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandMusicService.getPage(islandMusic, pageNum, pageSize));
        }
        return Response.success(islandMusicService.getList(islandMusic));
    }

    @RequestMapping(value = "music", method = RequestMethod.POST)
    public Response<IslandMusic> add(@RequestBody IslandMusic islandMusic) {
        return Response.success(islandMusicService.add(islandMusic));
    }

    @RequestMapping(value = "music", method = RequestMethod.PUT)
    public Response<IslandMusic> edit(@RequestBody IslandMusic islandMusic) {
        return Response.success(islandMusicService.edit(islandMusic));
    }
}
