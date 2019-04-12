package com.island.monster.controller;

import com.island.monster.bean.IslandMotto;
import com.island.monster.common.Response;
import com.island.monster.service.IslandMottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/island/")
public class IslandMottoController {

    @Autowired
    private IslandMottoService islandMottoService;

    /**
     * island add a new motto
     *
     * @param islandMotto
     * @return
     */
    @RequestMapping(value = "motto", method = RequestMethod.POST)
    public Response<IslandMotto> add(@RequestBody IslandMotto islandMotto) {
        return Response.success((IslandMotto) islandMottoService.add(islandMotto));
    }

    /**
     * island delete a motto with the provide id logically
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "motto/{id}", method = RequestMethod.DELETE)
    public Response<IslandMotto> setDel(@PathVariable("id") Integer id) {
        return Response.success(islandMottoService.setDel(id));
    }

    /**
     * edit the motto
     *
     * @param islandMotto
     * @return
     */
    @RequestMapping(value = "motto", method = RequestMethod.PUT)
    public Response<IslandMotto> edit(@RequestBody IslandMotto islandMotto) {
        return Response.success(islandMottoService.edit(islandMotto));
    }

    /**
     * get a motto that satisfy the provide conditions (with showingDate)
     *
     * @param islandMotto
     * @return
     */
    @RequestMapping(value = "motto", method = RequestMethod.GET)
    public Response<IslandMotto> getOne(IslandMotto islandMotto) {
        return Response.success(islandMottoService.getOne(islandMotto));
    }

    @RequestMapping(value = "motto/next/{currentId}", method = RequestMethod.GET)
    public Response<IslandMotto> next(@PathVariable("currentId") Integer currentId) {
        return Response.success(islandMottoService.nextMotto(currentId));
    }

    /**
     * get list or pageInfo of mottos that satisfy the provide conditions
     *
     * @param islandMotto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "mottos", method = RequestMethod.GET)
    public Response<?> get(IslandMotto islandMotto, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            return Response.success(islandMottoService.getPage(islandMotto, pageNum, pageSize));
        }
        return Response.success(islandMottoService.getList(islandMotto));
    }

}
