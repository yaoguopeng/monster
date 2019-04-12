package com.island.monster.controller;

import com.island.monster.bean.IslandPost;
import com.island.monster.common.Response;
import com.island.monster.service.IslandPostService;
import com.island.monster.service.IslandUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/island/")
public class IslandPostController {

    @Autowired
    private IslandUploadService islandUploadService;

    @Autowired
    private IslandPostService islandPostService;

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public Response<IslandPost> addPost(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadPost(request));
    }

    @RequestMapping(value = "posts", method = RequestMethod.GET)
    public Response<?> get(IslandPost islandPost, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPostService.getPage(islandPost, pageNum, pageSize));
        }
        return Response.success(islandPostService.getList(islandPost));
    }

    @RequestMapping(value = "post", method = RequestMethod.GET)
    public Response<IslandPost> getOne(@RequestParam("id") String id) {
        return Response.success(islandPostService.getOne(id));
    }

    @RequestMapping(value = "post/{id}", method = RequestMethod.DELETE)
    public Response<IslandPost> delete(@PathVariable("id") String id) {
        return Response.success(islandPostService.setDeleted(id));
    }
}
