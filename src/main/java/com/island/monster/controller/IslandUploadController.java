package com.island.monster.controller;

import com.island.monster.common.Response;
import com.island.monster.service.IslandUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/island_upload/")
public class IslandUploadController {

    @Autowired
    private IslandUploadService islandUploadService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadIndex(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadIndex(request));
    }

    @RequestMapping(value = "/background", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadBackground(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadBackground(request));
    }

    @RequestMapping(value = "/landscape", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadLandscape(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadLandscape(request));
    }

    @RequestMapping(value = "/joke", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadJoke(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadJoke(request));
    }

    @RequestMapping(value = "/motto", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadMotto(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadMotto(request));
    }

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadMovie(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadMovie(request));
    }

    @RequestMapping(value = "/music", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadMusic(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadMusic(request));
    }

    @RequestMapping(value = "/painting", method = RequestMethod.POST)
    @ResponseBody

    public Response<?> uploadPainting(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadPainting(request));
    }

    @RequestMapping(value = "/passage", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadPassage(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadPassage(request));
    }

    @RequestMapping(value = "/poem", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadPoem(HttpServletRequest request) {
        return Response.success(islandUploadService.uploadPoem(request));
    }

}
