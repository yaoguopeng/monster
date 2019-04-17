package com.island.monster.controller;

import com.island.monster.bean.IslandPostReply;
import com.island.monster.common.Response;
import com.island.monster.service.IslandPostReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/island/")
public class IslandPostReplyController {

    @Autowired
    private IslandPostReplyService islandPostReplyService;

    @RequestMapping(value = "reply", method = RequestMethod.POST)
    public Response<IslandPostReply> add(@Valid @RequestBody IslandPostReply islandPostReply) {
        return Response.success(islandPostReplyService.add(islandPostReply));
    }

    @RequestMapping(value = "reply/{id}", method = RequestMethod.DELETE)
    public Response<IslandPostReply> setDeleted(@PathVariable("id") String id) {
        return Response.success(islandPostReplyService.setDeleted(id));
    }

    @RequestMapping(value = "reply", method = RequestMethod.PUT)
    public Response<IslandPostReply> edit(@RequestBody IslandPostReply islandPostReply) {
        return Response.success(islandPostReplyService.edit(islandPostReply));
    }

    @RequestMapping(value = "reply", method = RequestMethod.GET)
    public Response<IslandPostReply> getOne(@RequestParam("id") String id) {
        return Response.success(islandPostReplyService.getOne(id));
    }

    @RequestMapping(value = "replies", method = RequestMethod.GET)
    public Response<?> get(IslandPostReply islandPostReply, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandPostReplyService.getPage(islandPostReply, pageNum, pageSize));
        }
        return Response.success(islandPostReplyService.getList(islandPostReply));
    }
}
