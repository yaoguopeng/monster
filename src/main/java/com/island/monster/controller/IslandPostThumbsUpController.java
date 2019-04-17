package com.island.monster.controller;

import com.island.monster.bean.IslandPostThumbsUp;
import com.island.monster.common.Response;
import com.island.monster.service.IslandPostThumbsUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/island/")
public class IslandPostThumbsUpController {

    @Autowired
    private IslandPostThumbsUpService islandPostThumbsUpService;

    @RequestMapping(value = "thumbs_up", method = RequestMethod.POST)
    public Response<IslandPostThumbsUp> add(@Valid @RequestBody IslandPostThumbsUp islandPostThumbsUp) {
        return Response.success(islandPostThumbsUpService.add(islandPostThumbsUp));
    }

    @RequestMapping(value = "thumbs_up", method = RequestMethod.DELETE)
    public Response<Integer> cancel(IslandPostThumbsUp islandPostThumbsUp) {
        return Response.success(islandPostThumbsUpService.remove(islandPostThumbsUp));
    }

    @RequestMapping(value = "thumbs_up", method = RequestMethod.GET)
    public Response<?> get(IslandPostThumbsUp islandPostThumbsUp) {
        return Response.success(islandPostThumbsUpService.getList(islandPostThumbsUp));
    }

}
