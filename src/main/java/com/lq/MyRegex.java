package com.lq;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by lq on 2020/1/13.
 */
public class MyRegex {

    //ab .*
    //

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }

    }

    static Boolean[][] map;

    public static boolean isMatch2(String s, String p) {
        //存对应字母的匹配结果
        map = new Boolean[s.length() + 1][p.length() + 1];
        boolean result = match(0, 0, s, p);
        return result;

    }

    private static boolean match(int i, int j, String s, String p) {
        if(map[i][j] != null) {
            return map[i][j];
        }
        boolean result;
        if(j == p.length()) {
            result = i == s.length();
        } else {
            boolean currentMatch = i < s.length()
                    && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
                result = (match(i, j + 2, s, p)
                        || currentMatch && match(i + 1, j, s, p));
            } else {
                result = currentMatch && match(i + 1, j+ 1, s, p);
            }
        }
        map[i][j] = result;
        return result;
    }

    /**
     * 求数组中的最大面积
     */
    private static int maxArea(int[] height) {
        int area = 0;
        for(int i = 0; i < height.length - 1;) {
            for(int j = height.length - 1; j > i ; j--) {
                if(Math.abs(height[j] - height[i]) >= j - i) {
                    int tmpArea = Math.min(height[j] , height[i]) * (j - i);
                    if(tmpArea > area) {
                        area = tmpArea;
                    }
                }
                if(j - i <= 1) {
                    i++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
//        boolean result = isMatch("ab", ".*c");
//        System.out.println(result);
//
//        boolean result2 = isMatch2("ab", ".*c");
//        System.out.println("result2:" + result2);

        int [] a = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(a);
        System.out.println(result);

    }
}
