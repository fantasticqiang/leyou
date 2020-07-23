package com.lq.easy2;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
 * @author lq
 * @date 2020-06-04 17:38
 */
public class T401readBinaryWatch {

    public static void main(String[] args) {
//        List<String> strings = readBinaryWatch(2);
//        System.out.println(strings.size());
//        StringBuilder sb = new StringBuilder();
//        sb.append("\"" + strings.get(0) + "\"");
//        for (int i = 1; i < strings.size(); i++) {
//            sb.append(",").append("\"" + strings.get(i) + "\"");
//        }
//        System.out.println(sb);


        int n = 2;
        int[] tmp = new int[n];
        ArrayList<int[]> result = new ArrayList<>();
        combine2(0, n, tmp, result);
        int line = 0;
        StringBuilder sb = new StringBuilder();;
        for (int i = 0; i < result.size(); i++) {
            int[] t = result.get(i);
            if(t[0] != line) {
                line++;
                System.out.println(sb.toString());
                sb = new StringBuilder();
            }
            if(t[0] == line) {
                sb.append(t[0]);
                for (int j = 1; j < t.length; j++) {
                    sb.append("_").append(t[j]);
                }
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());

//        String[] right = {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
//        String[] my = {"0:03","0:05","0:09","0:17","0:33","1:01","2:01","4:01","8:01","0:06","0:10","0:18","0:34","1:02","2:02","4:02","8:02","0:12","0:20","0:36","1:04","2:04","4:04","8:04","0:24","0:40","1:08","2:08","4:08","8:08","0:48","1:16","2:16","4:16","8:16","1:32","2:32","4:32","8:32","3:00","5:00","9:00","6:00","10:00"};
//        HashSet<String> mySet = new HashSet<>();
//        System.out.println("right length : " + right.length);
//        System.out.println("my length : " + my.length);
//        for (String t : my) {
//            mySet.add(t);
//        }
//        for (String t : right) {
//            if(!mySet.contains(t)) {
//                System.out.println("非法 ：" + t);
//            }
//        }
//        HashSet<String> rightSet = new HashSet<>();
//        for (String t : right) {
//            rightSet.add(t);
//        }
//        for (String t : my) {
//            if(!rightSet.contains(t)) {
//                System.out.println("非法 ： " + t);
//            }
//        }
    }

    /**
     * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
     *
     * 每个 LED 代表一个 0 或 1，最低位在右侧。
     *
     * @return
     */
    public static List<String> readBinaryWatch(int num) {
        int[] tmp = new int[num];
        ArrayList<String> result = new ArrayList<>();
        combine(0, num, tmp, result);
        return result;
    }

    private static void combine(int start, int n, int[] tmp, List<String> result) {
        if(n == 0) {
            int[] tmpCopy = Arrays.copyOfRange(tmp, 0, tmp.length);
            String s = generateMinuteString(tmpCopy);
            if(s != null) {
                result.add(s);
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            tmp[tmp.length - n] = i;
            combine(i + 1, n - 1, tmp, result);
        }
    }

    private static String generateMinuteString(int[] tmp) {
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] < 4) {
                hour += 1 << (3 - tmp[i]);
            } else {
                minute += 1 << (9 - tmp[i]);
            }
        }
        if(hour <= 11 && minute <= 59) {
            return String.format("%d:%02d", hour, minute);
        }
        return null;
    }

    private static void combine2(int start, int num, int[] tmp, List<int[]> result) {
        if(num == 0) {
            int[] tmpCopy = Arrays.copyOfRange(tmp, 0, tmp.length);
            result.add(tmpCopy);
            return;
        }
        for (int i = start; i <= 9; i++) {
            tmp[tmp.length - num] = i;
            combine2(i + 1, num - 1, tmp, result);
        }
    }




}
