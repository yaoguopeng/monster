package com.island.monster.controller;

import com.island.monster.bean.IslandIndex;
import com.island.monster.common.Response;
import com.island.monster.service.IslandIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/island/")
public class IslandIndexController {

    @Autowired
    private IslandIndexService islandIndexService;

    /**
     * get index from db randomly if there is no one match the conditions
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Response<IslandIndex> getIndex(IslandIndex islandIndex) {
        return Response.success(islandIndexService.getOne(islandIndex));
    }

    @RequestMapping(value = "indexs", method = RequestMethod.GET)
    public Response<?> get(IslandIndex islandIndex, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            return Response.success(islandIndexService.getPage(islandIndex, pageNum, pageSize));
        }
        return Response.success(islandIndexService.getList(islandIndex));
    }
}

