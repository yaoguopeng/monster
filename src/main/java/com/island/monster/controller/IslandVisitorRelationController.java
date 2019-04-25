package com.island.monster.controller;

import com.island.monster.bean.IslandVisitorRelation;
import com.island.monster.common.Response;
import com.island.monster.service.IslandVisitorRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/island/")
public class IslandVisitorRelationController {

    @Autowired
    private IslandVisitorRelationService islandVisitorRelationService;

    @RequestMapping(value = "visitor/relation", method = RequestMethod.POST)
    public Response<IslandVisitorRelation> add(@Valid @RequestBody IslandVisitorRelation islandVisitorRelation) {
        return Response.success(islandVisitorRelationService.addConcern(islandVisitorRelation));
    }

    @RequestMapping(value = "visitor/relation", method = RequestMethod.PUT)
    public Response<IslandVisitorRelation> cancel(@Valid @RequestBody IslandVisitorRelation islandVisitorRelation) {
        return Response.success(islandVisitorRelationService.cancelConcern(islandVisitorRelation));
    }

    @RequestMapping(value = "visitor/relation/set_important", method = RequestMethod.PUT)
    public Response<IslandVisitorRelation> setImportant(@Valid IslandVisitorRelation islandVisitorRelation) {
        return Response.success(islandVisitorRelationService.setImportant(islandVisitorRelation));
    }

    @RequestMapping(value = "visitor/relation/cancel_important", method = RequestMethod.PUT)
    public Response<IslandVisitorRelation> cancelImportant(@Valid IslandVisitorRelation islandVisitorRelation) {
        return Response.success(islandVisitorRelationService.cancelImportant(islandVisitorRelation));
    }
}
