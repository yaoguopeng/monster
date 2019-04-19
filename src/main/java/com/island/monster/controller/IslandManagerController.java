package com.island.monster.controller;

import com.island.monster.bean.IslandManager;
import com.island.monster.common.Response;
import com.island.monster.service.IslandManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandManagerController {


    @Autowired
    private IslandManagerService islandManagerService;

    /**
     * manager update self information after check ckeckCode
     *
     * @param islandManager
     * @return
     */
    @RequestMapping(value = "manager", method = RequestMethod.PUT)
    public Response<?> edit(@RequestBody IslandManager islandManager) {
        return null;
    }


    /**
     * The manager of Island register
     *
     * @param islandManager
     * @return
     */
    @RequestMapping(value = "manager/register", method = RequestMethod.POST)
    public Response<?> register(@RequestBody IslandManager islandManager) {
        IslandManager result = islandManagerService.add(islandManager);
        if (result == null) {
            return Response.failed("failed to register cause by the registName has been occupied", 1);
        }
        return Response.success(result);
    }

    /**
     * The manager of Island login with registerName and registerPassword
     *
     * @param islandManager
     * @return
     */
    @RequestMapping(value = "manager/login", method = RequestMethod.POST)
    public Response<?> login(@RequestBody IslandManager islandManager) {
        if (!islandManagerService.login(islandManager)) {
            return Response.failed("with wrong registerName or registerPassword", 1);
        }
        return Response.success(true);
    }

    /**
     * get information of the very manager with the provide id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "manager/{id}", method = RequestMethod.GET)
    public Response<IslandManager> getOne(@PathVariable("id") String id) {
        return Response.success(islandManagerService.getOne(id));
    }
}
