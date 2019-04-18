package com.island.monster.common;

/**
 * 时光小岛通用类，常量、枚举等
 */
public class IslandCommon {

    /**
     * 作品类型：首页INDEX/格言MOTTO/音乐MUSIC/名画PAINTING/美文PASSAGE/诗歌POEM/笑话JOKE/电影MOVIE/风景LANDSCAPE
     */
    public enum WorkType {
        INDEX, MOTTO, MUSIC, PAINTING, PASSAGE, POEM, JOKE, MOVIE, LANDSCAPE
    }

    /**
     * 主题类型：无主题NONE，心情MOOD，文艺LITERATURE，日常DAILY，其他OTHER
     */
    public enum TopicType {
        NONE,MOOD,LITERATURE,DAILY,OTHER
    }

    /**
     * 消息类型：来自评价COMMENT/来自回复REPLY
     */
    public enum MessageType {
        COMMENT, REPLY
    }

    public static String yes() {
        return "1";
    }

    public static String no() {
        return "0";
    }
}
