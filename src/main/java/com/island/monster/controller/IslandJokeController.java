package com.island.monster.controller;

import com.island.monster.bean.IslandJoke;
import com.island.monster.common.Response;
import com.island.monster.service.IslandJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandJokeController {

    @Autowired
    private IslandJokeService IslandJokeService;

    @RequestMapping(value = "joke/id/{id}", method = RequestMethod.GET)
    public Response<IslandJoke> getById(@PathVariable("id") Integer id) {
        return Response.success(IslandJokeService.getById(id));
    }

    /**
     * get a joke from db randomly
     *
     * @return
     */
    @RequestMapping(value = "joke", method = RequestMethod.GET)
    public Response<IslandJoke> randomJoke() {
        return Response.success(IslandJokeService.randomJoke());
    }

    @RequestMapping(value = "joke/next/{currentId}", method = RequestMethod.GET)
    public Response<IslandJoke> nextJoke(@PathVariable("currentId") Integer currentId) {
        return Response.success(IslandJokeService.nextJoke(currentId));
    }

    @RequestMapping(value = "joke", method = RequestMethod.PUT)
    public Response<IslandJoke> edit(@RequestBody IslandJoke islandJoke) {
        return Response.success(IslandJokeService.edit(islandJoke));
    }

    @RequestMapping(value = "joke", method = RequestMethod.POST)
    public Response<IslandJoke> add(@RequestBody IslandJoke islandJoke) {
        return Response.success(IslandJokeService.add(islandJoke));
    }

    @RequestMapping(value = "jokes", method = RequestMethod.GET)
    public Response<?> get(IslandJoke islandJoke,@RequestParam(value = "pageSize", required = false) Integer pageSize,
                           @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(IslandJokeService.getPage(islandJoke, pageNum,pageSize));
        } else {
            return Response.success(IslandJokeService.getList(islandJoke));
        }
    }
}
