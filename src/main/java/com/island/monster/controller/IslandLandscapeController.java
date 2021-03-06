package com.island.monster.controller;

import com.island.monster.bean.IslandLandscape;
import com.island.monster.common.Response;
import com.island.monster.service.IslandLandscapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/island/")
public class IslandLandscapeController {

    @Autowired
    private IslandLandscapeService islandLandscapeService;

    @RequestMapping(value = "landscape", method = RequestMethod.GET)
    public Response<IslandLandscape> getOne(IslandLandscape islandLandscape) {
        return Response.success(islandLandscapeService.getOne(islandLandscape));
    }

    @RequestMapping(value = "landscapes", method = RequestMethod.GET)
    public Response<?> get(IslandLandscape islandLandscape, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            return Response.success(islandLandscapeService.getPage(islandLandscape, pageNum, pageSize));
        }
        return Response.success(islandLandscapeService.getList(islandLandscape));
    }
}
