package com.island.monster.controller;

import com.island.monster.bean.IslandPoem;
import com.island.monster.common.Response;
import com.island.monster.service.IslandPoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandPoemController {

    @Autowired
    private IslandPoemService islandPoemService;

    @RequestMapping(value = "poem/id/{id}", method = RequestMethod.GET)
    public Response<IslandPoem> getById(@PathVariable("id") Integer id) {
        return Response.success(islandPoemService.getById(id));
    }

    @RequestMapping(value = "poem", method = RequestMethod.POST)
    public Response<IslandPoem> add(@RequestBody IslandPoem islandPoem) {
        return Response.success(islandPoemService.add(islandPoem));
    }

    @RequestMapping(value = "poem/remove/{id}", method = RequestMethod.DELETE)
    public Response<IslandPoem> delete(@PathVariable("id") Integer id) {
        return Response.success(islandPoemService.remove(id));
    }

    @RequestMapping(value = "poem/{id}", method = RequestMethod.DELETE)
    public Response<IslandPoem> setDel(@PathVariable("id") Integer id) {
        return Response.success(islandPoemService.setDel(id));
    }

    @RequestMapping(value = "poem", method = RequestMethod.PUT)
    public Response<IslandPoem> edit(@RequestBody IslandPoem islandPoem) {
        return Response.success(islandPoemService.edit(islandPoem));
    }

    @RequestMapping(value = "poem", method = RequestMethod.GET)
    public Response<IslandPoem> getOne(IslandPoem islandPoem) {
        return Response.success(islandPoemService.getOne(islandPoem));
    }

    @RequestMapping(value = "poem/next/{currentId}", method = RequestMethod.GET)
    public Response<IslandPoem> next(@PathVariable("currentId") Integer currentId) {
        return Response.success(islandPoemService.nextPoem(currentId));
    }

    @RequestMapping(value = "poems", method = RequestMethod.GET)
    public Response<?> get(IslandPoem islandPoem, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPoemService.getPage(islandPoem, pageNum, pageSize));
        }
        return Response.success(islandPoemService.getList(islandPoem));
    }
}

