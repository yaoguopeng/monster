package com.island.monster.controller;

import com.island.monster.bean.IslandTopic;
import com.island.monster.common.Response;
import com.island.monster.service.IslandTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandTopicController {

    @Autowired
    private IslandTopicService islandTopicService;

    @RequestMapping(value = "topic", method = RequestMethod.POST)
    public Response<IslandTopic> add(@RequestBody IslandTopic islandTopic) {
        return Response.success(islandTopicService.add(islandTopic));
    }

    @RequestMapping(value = "topic", method = RequestMethod.GET)
    public Response<IslandTopic> getOne(@RequestParam("id") String id) {
        return Response.success(islandTopicService.getOne(id));
    }

    @RequestMapping(value = "topic/topicName", method = RequestMethod.GET)
    public Response<IslandTopic> getByTopicName(@RequestParam("topicName") String topicName) {
        return Response.success(islandTopicService.getByTopicName(topicName));
    }

    @RequestMapping(value = "topics", method = RequestMethod.GET)
    public Response<?> get(IslandTopic islandTopic, @RequestParam(value = "sortBy", required = false) String sortBy, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandTopicService.getPage(islandTopic, sortBy, pageNum, pageSize));
        }
        return Response.success(islandTopicService.getList(sortBy, islandTopic));
    }

    @RequestMapping(value = "topics/user", method = RequestMethod.GET)
    public Response<?> onesFavoriteTopic(@RequestParam("unionId") String unionId, @RequestParam(value = "sortBy", required = false) String sortBy, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(islandTopicService.onesFavoriteTopic(unionId, sortBy, pageNum, pageSize));
        }
        return Response.success(islandTopicService.onesFavoriteTopic(sortBy, unionId));
    }
}
