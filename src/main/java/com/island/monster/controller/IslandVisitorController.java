package com.island.monster.controller;

import com.island.monster.bean.IslandVisitor;
import com.island.monster.common.Response;
import com.island.monster.service.IslandVisitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/island/")
public class IslandVisitorController {

    @Autowired
    private IslandVisitorService islandVisitorService;

    @RequestMapping(value = "visitor", method = RequestMethod.POST)
    public Response<IslandVisitor> visit(@Valid @RequestBody IslandVisitor IslandVisitor) {
        return Response.success(islandVisitorService.update(IslandVisitor));
    }

}
