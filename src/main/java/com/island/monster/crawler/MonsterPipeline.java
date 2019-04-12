package com.island.monster.crawler;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

public class MonsterPipeline {


    /**
    public static void main(String[] args) {
        Spider.create(new MonsterPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.juzimi.com/writer/%E9%A1%BE%E5%9F%8E")
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
     */
}
