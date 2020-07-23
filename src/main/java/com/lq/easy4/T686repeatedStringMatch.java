package com.lq.easy4;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author lq
 * @date 2020-07-20 10:47
 */
public class T686repeatedStringMatch {

    /**
     * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
     *
     * 举个例子，A = "abcd"，B = "cdabcdab"。
     *
     * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
     *
     * 注意:
     *
     *  A 与 B 字符串的长度在1和10000区间范围内。
     * @param args
     */
    public static void main(String[] args) {
        int r = repeatedStringMatch("aaac", "aac");
        System.out.println(r);

        int r2 = repeatedStringMatch("a", "aa");
        System.out.println(r2);
    }


    public static int repeatedStringMatch(String A, String B) {
        int maxLen = B.length() + 2 * A.length();
        StringBuilder sb = new StringBuilder(A);
        for (int i = 1; sb.length() <= maxLen; i++) {
            if (sb.toString().contains(B)) return i;
            sb.append(A);
        }
        return -1;
    }

    //适用sunday算法
    public static int sunDayStrStr(String str, String pattern) {
        char[] strChars = str.toCharArray();
        char[] pChars = pattern.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        for (int i = 0; i < pChars.length; i++) {
            map[pChars[i]] = i;
        }
        int pos = 0;
        int lenS = strChars.length;
        int lenP = pChars.length;
        while (pos <= lenS - lenP) {
            int j = 0;
            for (int i = pos; j < lenP && i < lenS && strChars[i] == pChars[j];) {
                i++; j++;
            }
            if (j == pChars.length) {
                return pos;
            } else {
                if (pos + lenP < lenS) {
                    pos += lenP - map[strChars[pos + lenP]];
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
