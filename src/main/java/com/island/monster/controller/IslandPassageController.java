package com.island.monster.controller;

import com.island.monster.bean.IslandPassage;
import com.island.monster.common.Response;
import com.island.monster.service.IslandPassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandPassageController {

    @Autowired
    private IslandPassageService islandPassageService;

    @RequestMapping(value = "passage", method = RequestMethod.POST)
    public Response<IslandPassage> add(@RequestBody IslandPassage islandPassage) {
        return Response.success(islandPassageService.add(islandPassage));
    }

    @RequestMapping(value = "passage/remove/{id}", method = RequestMethod.DELETE)
    public Response<IslandPassage> delete(@PathVariable("id") Integer id) {
        return Response.success(islandPassageService.remove(id));
    }

    @RequestMapping(value = "passage/{id}", method = RequestMethod.DELETE)
    public Response<IslandPassage> setDel(@PathVariable("id") Integer id) {
        return Response.success(islandPassageService.setDel(id));
    }

    @RequestMapping(value = "passage", method = RequestMethod.PUT)
    public Response<IslandPassage> edit(@RequestBody IslandPassage islandPassage) {
        return Response.success(islandPassageService.edit(islandPassage));
    }

    @RequestMapping(value = "passage", method = RequestMethod.GET)
    public Response<IslandPassage> getOne(IslandPassage islandPassage) {
        return Response.success(islandPassageService.getOne(islandPassage));
    }

    @RequestMapping(value = "passage/next/{currentId}", method = RequestMethod.GET)
    public Response<IslandPassage> next(@PathVariable("currentId") Integer currentId) {
        return Response.success(islandPassageService.nextPassage(currentId));
    }

    @RequestMapping(value = "passages", method = RequestMethod.GET)
    public Response<?> get(IslandPassage islandPassage, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPassageService.getPage(islandPassage, pageNum, pageSize));
        }
        return Response.success(islandPassageService.getList(islandPassage));
    }
}
