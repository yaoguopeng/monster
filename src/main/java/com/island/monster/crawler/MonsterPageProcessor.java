package com.island.monster.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class MonsterPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setCharset("utf8");

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        System.out.println("page:"+page);
//        System.out.println("html:"+page.getHtml());
//        System.out.println("views-field-phpcode:"+page.getHtml().xpath("//div[@class='views-field-phpcode']"));
        String contentStr = page.getHtml().xpath("//div[@class='views-row views-row-1 views-row-odd views-row-first']").xpath("//div[@class='views-field-phpcode-1']").xpath("//a[@class='xlistju']").get();
        String content = contentStr.substring(contentStr.lastIndexOf("class=\"xlistju\">") + 16, contentStr.lastIndexOf("</a>"));
        System.out.println("内容:" + content);
        String fromStr = page.getHtml().xpath("//div[@class='views-row views-row-1 views-row-odd views-row-first']").xpath("//a[@class='active']").get();
        String from = fromStr.substring(fromStr.lastIndexOf("class=\"active\">") + 15, fromStr.lastIndexOf("</a>"));
        System.out.println("选自:" + from);

//        page.putField("document",page.getHtml());
        page.putField("内容", content);
        page.putField("选自",from);
        /**
         // 部分二：定义如何抽取页面信息，并保存下来
         page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
         page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
         if (page.getResultItems().get("name") == null) {
         //skip this page
         page.setSkip(true);
         }
         page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

         // 部分三：从页面发现后续的url地址来抓取
         page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());

         */
    }

    @Override
    public Site getSite() {
        return site;
    }

    /**
    public static void main(String[] args) {

        Spider.create(new MonsterPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://github.com/code4craft")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
     */

}
