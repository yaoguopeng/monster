package com.island.monster.crawler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonsterPipeline {

    @Test
    public void test(){
        Spider.create(new MonsterPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.juzimi.com/writer/%E9%A1%BE%E5%9F%8E")
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
