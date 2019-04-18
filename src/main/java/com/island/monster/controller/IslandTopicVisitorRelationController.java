package com.island.monster.controller;

import com.island.monster.bean.IslandTopicVisitorRelation;
import com.island.monster.common.Response;
import com.island.monster.service.IslandTopicVisitorRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/island/")
public class IslandTopicVisitorRelationController {

    @Autowired
    private IslandTopicVisitorRelationService islandTopicVisitorRelationService;

    @RequestMapping(value = "topic_visitor_relation", method = RequestMethod.POST)
    public Response<IslandTopicVisitorRelation> add(@Valid @RequestBody IslandTopicVisitorRelation islandTopicVisitorRelation) {
        return Response.success(islandTopicVisitorRelationService.add(islandTopicVisitorRelation));
    }

    @RequestMapping(value = "topic_visitor_relation", method = RequestMethod.DELETE)
    public Response<Integer> cancel(@Valid IslandTopicVisitorRelation islandTopicVisitorRelation) {
        return Response.success(islandTopicVisitorRelationService.cancel(islandTopicVisitorRelation));
    }

}
