package com.island.monster.controller;

import com.island.monster.bean.VisitorStorehouse;
import com.island.monster.common.Response;
import com.island.monster.service.VisitorStorehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/island/")
public class VisitorStorehouseController {

    @Autowired
    private VisitorStorehouseService visitorStorehouseService;

    @RequestMapping(value = "favorite", method = RequestMethod.POST)
    public Response<?> add(@Valid @RequestBody VisitorStorehouse visitorStorehouse) {
        return Response.success(visitorStorehouseService.add(visitorStorehouse));
    }

    @RequestMapping(value = "favorite/{id}", method = RequestMethod.DELETE)
    public Response<?> cancel(@PathVariable("id") Integer id) {
        return Response.success(visitorStorehouseService.cancel(id));
    }

    @RequestMapping(value = "favorite", method = RequestMethod.GET)
    public Response<?> get(VisitorStorehouse visitorStorehouse, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.getPage(visitorStorehouse, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.getList(visitorStorehouse));
    }

    @RequestMapping(value = "favorite/joke/{unionId}", method = RequestMethod.GET)
    public Response<?> favoriteJoke(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.onesFavoriteJoke(unionId, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.onesFavoriteJoke(unionId));
    }

    @RequestMapping(value = "favorite/motto/{unionId}", method = RequestMethod.GET)
    public Response<?> favoriteMotto(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.onesFavoriteMotto(unionId, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.onesFavoriteMotto(unionId));
    }

    @RequestMapping(value = "favorite/movie/{unionId}", method = RequestMethod.GET)
    public Response<?> favoriteMovie(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.onesFavoriteMovie(unionId, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.onesFavoriteMovie(unionId));
    }

    @RequestMapping(value = "favorite/music/{unionId}", method = RequestMethod.GET)
    public Response<?> favoriteMusic(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.onesFavoriteMusic(unionId, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.onesFavoriteMusic(unionId));
    }

    @RequestMapping(value = "favorite/painting/{unionId}", method = RequestMethod.GET)
    public Response<?> favoritePainting(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.onesFavoritePainting(unionId, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.onesFavoritePainting(unionId));
    }

    @RequestMapping(value = "favorite/passage/{unionId}", method = RequestMethod.GET)
    public Response<?> favoritePassage(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.onesFavoritePassage(unionId, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.onesFavoritePassage(unionId));
    }

    @RequestMapping(value = "favorite/poem/{unionId}", method = RequestMethod.GET)
    public Response<?> favoritePoem(@PathVariable("unionId") String unionId, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        if (pageSize != null && pageNum != null) {
            return Response.success(visitorStorehouseService.onesFavoritePoem(unionId, pageSize, pageNum));
        }
        return Response.success(visitorStorehouseService.onesFavoritePoem(unionId));
    }
}
