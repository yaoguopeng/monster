package com.island.monster.controller;

import com.island.monster.bean.IslandPainting;
import com.island.monster.common.Response;
import com.island.monster.service.IslandPaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandPaintingController {

    @Autowired
    private IslandPaintingService islandPaintingService;

    @RequestMapping(value = "painting/id/{id}", method = RequestMethod.GET)
    public Response<IslandPainting> getById(@PathVariable("id") Integer id) {
        return Response.success(islandPaintingService.getById(id));
    }

    @RequestMapping(value = "painting", method = RequestMethod.POST)
    public Response<IslandPainting> add(@RequestBody IslandPainting islandPainting) {
        return Response.success(islandPaintingService.add(islandPainting));
    }

    @RequestMapping(value = "painting/remove/{id}", method = RequestMethod.DELETE)
    public Response<IslandPainting> delete(@PathVariable("id") Integer id) {
        return Response.success(islandPaintingService.remove(id));
    }

    @RequestMapping(value = "painting/{id}", method = RequestMethod.DELETE)
    public Response<IslandPainting> setDel(@PathVariable("id") Integer id) {
        return Response.success(islandPaintingService.setDel(id));
    }

    @RequestMapping(value = "painting", method = RequestMethod.PUT)
    public Response<IslandPainting> edit(@RequestBody IslandPainting islandPainting) {
        return Response.success(islandPaintingService.edit(islandPainting));
    }

    @RequestMapping(value = "painting", method = RequestMethod.GET)
    public Response<IslandPainting> getOne(IslandPainting islandPainting) {
        return Response.success(islandPaintingService.getOne(islandPainting));
    }

    @RequestMapping(value = "painting/next/{currentId}", method = RequestMethod.GET)
    public Response<IslandPainting> next(@PathVariable("currentId") Integer currentId) {
        return Response.success(islandPaintingService.nextPainting(currentId));
    }

    @RequestMapping(value = "paintings", method = RequestMethod.GET)
    public Response<?> get(IslandPainting islandPainting, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPaintingService.getPage(islandPainting, pageNum, pageSize));
        }
        return Response.success(islandPaintingService.getList(islandPainting));
    }
}
