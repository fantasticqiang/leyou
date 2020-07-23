package com.lq.easy;

/**
 * Created by lq on 2020/5/2.
 * 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-strstr
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T5StrStr {

    public static void main(String[] args) {
//        int i = strStr("hello", "hello");
//        System.out.println(i);
//        int i2 = strStr("hamississippiff", "mississippi");
//        System.out.println(i2);
//        int i3 = strStr("mississippi", "issip");
//        System.out.println(i3);
//
//        int i_1 = strStr2("hello", "hello");
//        System.out.println(i_1);
//        int i2_2 = strStr2("hamississippiff", "mississippi");
//        System.out.println(i2_2);
//        int i3_2 = strStr2("mississippi", "issip");
//        System.out.println(i3_2);

//        int kmp = strStr3("ABCABEABCABD", "ABCABD");
//        System.out.println(kmp);

        int sunday_1 = strStr4("ABCABEABCABD", "ABCABD");
        System.out.println(sunday_1);

    }

    public static int strStr(String haystack, String needle) {
        if("".equals(needle)) {
            return 0;
        }
        int str1Length = haystack.length();
        int str2length = needle.length();
        if(str2length > str1Length) {
            return -1;
        }
        int RESULT = 0;
        for(int i = 0; i < str1Length; i++) {
            char index = haystack.charAt(i);
            for(int j = 0; j < str2length; j++) {
                char index2 = needle.charAt(j);
                if(index != index2) {
                    i = RESULT;
                    RESULT = i + 1;
                    break;
                }
                if( j + 1 == str2length ) {
                    return RESULT;
                }
                if(str2length - j > str1Length - i) {
                    return -1;
                }
                i++;
                index = haystack.charAt(i);
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        int sLen = haystack.length();
        int pLen = needle.length();

        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen)
        {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                //①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
                i++;
                j++;
            }
            else
            {
                //②如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0
                i = i - j + 1;
                j = 0;
            }
        }
        //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    public static int strStr3(String haystack, String needle) {
        char[] target = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        // 目标字符串下标
        int i = 0;
        // 搜索词下标
        int j = 0;
        // 整体右移一位的部分匹配表
        int[] next = getNext(needle);

        while (i < target.length && j < pattern.length) {
            // j == -1 表示从搜索词最开始进行匹配
            if (j == -1 || target[i] == pattern[j]) {
                i++;
                j++;
                // 匹配失败时，查询“部分匹配表”，得到搜索词位置j以前的最大共同前后缀长度
                // 将j移动到最大共同前后缀长度的后一位，然后再继续进行匹配
            } else {
                j = next[j];
            }
        }

        // 搜索词每一位都能匹配成功，返回匹配的的起始位置
        if (j == pattern.length)
            return i - j;
        else
            return -1;
    }

    private static int[] getNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        // 第一位设为-1，方便判断当前位置是否为搜索词的最开始
        next[0] = -1;
        int i = 0;
        int j = -1;

        while(i < p.length - 1) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                if(p[i] != p[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }

            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * sunday 算法 匹配字符串
     *
     */
    public static int strStr4(String haystack, String needle) {
        //原字符串
        char[] strChars = haystack.toCharArray();
        // 模式字符串
        char[] patternChars = needle.toCharArray();
        int i = 0, j = 0;
        while (i <= strChars.length - patternChars.length + j) {
            if(strChars[i] != patternChars[j]) { //不匹配
                if(i == strChars.length - patternChars.length + j) {
                    return -1;
                }
                int pos = contains(patternChars, strChars[i + patternChars.length - j]);
                if(pos == - 1) {
                    i = i + patternChars.length - j + 1;
                    j = 0;
                } else {
                    i = i + patternChars.length - pos - j;
                    j = 0;
                }
            } else {
                if(j == patternChars.length - 1) {
                    return i - j;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }

    public static int contains(char[] chars, char ch) {
        for(int i = chars.length - 1; i >= 0; i--) {
            if(ch == chars[i]) {
                return i;
            }
        }
        return -1;
    }
}
