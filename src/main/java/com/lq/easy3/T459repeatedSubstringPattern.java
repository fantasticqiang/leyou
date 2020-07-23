package com.lq.easy3;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author lq
 * @date 2020-06-19 10:52
 */
public class T459repeatedSubstringPattern {

    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
     * 给定的字符串只含有小写英文字母，并且长度不超过10000。
     *
     * 示例 1:
     *
     * 输入: "abab"
     *
     * 输出: True
     *
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * 示例 2:
     *
     * 输入: "aba"
     *
     * 输出: False
     * 示例 3:
     *
     * 输入: "abcabcabcabc"
     *
     * 输出: True
     *
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     * @param args
     */
    public static void main(String[] args) {
        boolean r = repeatedSubstringPattern("babbabbabbabbab");
        System.out.println(r);

        boolean r2 = repeatedSubstringPattern2("babbabbabbabbab");
        System.out.println(r2);
    }

    public static boolean repeatedSubstringPattern(String s) {
        //假设初始子字符串的长度为s字符串长度的一半
        //假设s由两个字符串构成
        int len = s.length() / 2;
        while ( len >= 1) {
            if(s.length() % len == 0 ) {
                //s的长度是len的整倍数
                boolean sub = isSub(s, len);
                if(sub) return sub;
            }
            //s的长度不是len的整倍数
            len--;
        }
        return false;
    }

    private static boolean isSub(String s, int len) {
        //截取s的前len个字符,作为子字符串
        String subStr = s.substring(0, len);
        int index = 0;
        //判断s是否是n个subStr组成
        while (index < s.length()) {
            //截取index到index + len 一个一个比较
            if(!s.substring(index, index + len).equals(subStr)) {
                return false;
            }
            index += len;
        }
        //比较完都相等
        return true;
    }

    public static boolean repeatedSubstringPattern2(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length / 2; i > 0; i--)
            if (chars.length % i == 0 && repeat(chars, i))
                return true;
        return false;
    }

    public static boolean repeat(char[] chars, int i) {
        for (int j = 0; j < i; j++) {
            char c = chars[j];
            for (int k = j; k < chars.length; k += i)
                if (c != chars[k])
                    return false;
        }
        return true;
    }

}
