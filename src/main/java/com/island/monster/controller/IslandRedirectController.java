package com.island.monster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 重定向到对应的jsp页面
 */

@Controller
@RequestMapping("/island_redirector/")
public class IslandRedirectController {

    @RequestMapping("/anyway")
    public String transferToAnyway() {
        return "pageMachine";
    }

    @RequestMapping("/index")
    public String transferToIndex() {
        return "index";
    }

    @RequestMapping("/background")
    public String transferToBackground() {
        return "background";
    }

    @RequestMapping("/landscape")
    public String transferToLandscape() {
        return "landscape";
    }

    @RequestMapping("/joke")
    public String transferToJoke() {
        return "joke";
    }

    @RequestMapping("/motto")
    public String transferToMotto() {
        return "motto";
    }

    @RequestMapping("/movie")
    public String transferToMovie() {
        return "movie";
    }

    @RequestMapping("/music")
    public String transferToMusic() {
        return "music";
    }

    @RequestMapping("/painting")
    public String transferToPainting() {
        return "painting";
    }

    @RequestMapping("/passage")
    public String transferToPassage() {
        return "passage";
    }

    @RequestMapping("/poem")
    public String transferToPoem() {
        return "poem";
    }
}
