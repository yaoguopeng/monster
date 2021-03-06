package com.island.monster.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时光小岛工具类
 */
public class IslandUtil {

    private static String  PATTERN = "yyyy-MM-dd";

    /**
     * 给字符串加书名号
     * @param name
     * @return
     */
    public static String coverByQuotes(String name){
        StringBuffer result = new StringBuffer("《");
        result.append(name);
        result.append("》");
        return result.toString();
    }

    /**
     * 给字符串加前缀：——
     * @param name
     * @return
     */
    public static String addPrefix(String name){
        return "——"+name;
    }

    /**
     * 时光小岛所有实体类统一id生成规则
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 时光小岛获取当前时间的统一方式
     *
     * @return
     */
    public static Date now() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        return c.getTime();
    }

    /**
     * 时光小岛获取当前日期的统一方式
     * @return
     */
    public static Date currentDate(){
        Date currentDate = null;
        try {
            currentDate =  getSimpleDateFormat().parse(getSimpleDateFormat().format(now()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }

    /**
     * 获取闭区间[0,max]上的随机数
     *
     * @param max
     * @return
     */
    public static int getRandomId(int max) {
        Random r = new Random();
        return r.nextInt(max + 1);
    }

    /**
     * 获取 yyyy-MM-dd 格式的格式化模板
     *
     * @return
     */
    public static SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat(PATTERN);
    }
}
