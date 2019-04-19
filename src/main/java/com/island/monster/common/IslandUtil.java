package com.island.monster.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.security.MessageDigest;

/**
 * 时光小岛工具类
 */
public class IslandUtil {

    private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param password    字符
     * @param charsetName 编码
     * @return
     */
    public static String MD5Encode(String password, String charsetName) {
        String resultString = null;
        try {
            resultString = new String(password);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetName || "".equals(charsetName)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }

    /**
     * 给字符串加书名号
     *
     * @param name
     * @return
     */
    public static String coverByQuotes(String name) {
        StringBuffer result = new StringBuffer("《");
        result.append(name);
        result.append("》");
        return result.toString();
    }

    /**
     * 给字符串加前缀：——
     *
     * @param name
     * @return
     */
    public static String addPrefix(String name) {
        return "——" + name;
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
     *
     * @return
     */
    public static Date currentDate() {
        Date currentDate = null;
        try {
            currentDate = getSimpleDateFormat().parse(getSimpleDateFormat().format(now()));
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
        return FORMAT;
    }

    /**
     * 校验所传字符串是否时光小岛枚举类型
     *
     * @param workType
     * @return
     */
    public static Boolean validWorkType(String workType) {

        return getWorkTypeByName(workType) != null ? true : false;
    }

    /**
     * 通过字符串名称获取对应的枚举
     *
     * @param name
     * @return
     */
    public static IslandCommon.WorkType getWorkTypeByName(String name) {
        Map<String, IslandCommon.WorkType> map = new HashMap<>();
        map.put("INDEX", IslandCommon.WorkType.INDEX);
        map.put("MOTTO", IslandCommon.WorkType.MOTTO);
        map.put("MUSIC", IslandCommon.WorkType.MUSIC);
        map.put("PAINTING", IslandCommon.WorkType.PAINTING);
        map.put("PASSAGE", IslandCommon.WorkType.PASSAGE);
        map.put("POEM", IslandCommon.WorkType.POEM);
        map.put("JOKE", IslandCommon.WorkType.JOKE);
        map.put("MOVIE", IslandCommon.WorkType.MOVIE);
        map.put("LANDSCAPE", IslandCommon.WorkType.LANDSCAPE);
        return map.get(name);
    }

}
