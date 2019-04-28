package com.island.monster.controller;

import com.island.monster.bean.IslandPost;
import com.island.monster.common.Response;
import com.island.monster.service.IslandPostService;
import com.island.monster.service.IslandUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/island/")
public class IslandPostController {

    @Autowired
    private IslandUploadService islandUploadService;

    @Autowired
    private IslandPostService islandPostService;

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public Response<IslandPost> add(HttpServletRequest request, @RequestParam("postImage") MultipartFile[] postImage) {
        return Response.success(islandUploadService.uploadPost(request, postImage));
    }

    @RequestMapping(value = "post_edit", method = RequestMethod.POST)
    @ResponseBody
    public Response<IslandPost> edit(HttpServletRequest request, @RequestParam("postImage") MultipartFile[] postImage) {
        return Response.success(islandUploadService.editPost(request, postImage));
    }

    @RequestMapping(value = "posts", method = RequestMethod.GET)
    @ResponseBody
    public Response<?> get(IslandPost islandPost, @RequestParam(value = "currentUnionId") String currentUnionId,
                           @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPostService.getPage(islandPost, currentUnionId, pageNum, pageSize));
        }
        return Response.success(islandPostService.getList(islandPost, currentUnionId));
    }

    @RequestMapping(value = "posts/topics/{unionId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<?> onesFavoriteTopicPosts(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPostService.onesFavoriteTopicPosts(unionId, pageNum, pageSize));
        }
        return Response.success(islandPostService.onesFavoriteTopicPosts(unionId));
    }

    @RequestMapping(value = "posts/stars/{unionId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<?> onesStarsPosts(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPostService.onesStarsPosts(unionId, pageNum, pageSize));
        }
        return Response.success(islandPostService.onesStarsPosts(unionId));
    }

    @RequestMapping(value = "post", method = RequestMethod.GET)
    @ResponseBody
    public Response<IslandPost> getOne(@RequestParam("id") String id) {
        return Response.success(islandPostService.getOne(id));
    }

    @RequestMapping(value = "post/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response<IslandPost> delete(@PathVariable("id") String id) {
        return Response.success(islandPostService.setDeleted(id));
    }
}
