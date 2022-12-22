package com.island.monster.controller;

import com.island.monster.bean.IslandBackground;
import com.island.monster.common.Response;
import com.island.monster.service.IslandBackgroundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/island/")
@Api(tags = "背景管理")
public class IslandBackgroundController {

    @Autowired
    private IslandBackgroundService islandBackgroundService;

    @RequestMapping(value = "background", method = RequestMethod.GET)
    @ApiOperation("获取背景")
    public Response<IslandBackground> getOne(IslandBackground islandBackground) {
        return Response.success(islandBackgroundService.getOne(islandBackground));
    }

    @RequestMapping(value = "backgrounds", method = RequestMethod.GET)
    @ApiOperation("获取背景列表")
    public Response<?> get(IslandBackground islandBackground, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            return Response.success(islandBackgroundService.getPage(islandBackground, pageNum, pageSize));
        }
        return Response.success(islandBackgroundService.getList(islandBackground));
    }
}
