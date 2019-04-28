package com.island.monster.test;

import com.island.monster.common.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {

    @RequestMapping(value="monster",method= RequestMethod.POST)
    public Response<Monster> test(@RequestBody Monster monster){
        System.out.println(monster.getName());
        return Response.success(monster);
    }
}
