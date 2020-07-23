package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-14 18:58
 */
public class T409longestPalindrome {

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 示例 1:
     *
     * 输入:
     * "abccccdd"
     *
     * 输出:
     * 7
     *
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * @param args
     */
    public static void main(String[] args) {
        int r = longestPalindrome("AAAAAA");
        System.out.println(r);
    }

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[58];
        for (char c : chars) {
            map[c - 'A']++;
        }
        int len = 0;
        int single = 0;
        for (int i : map) {
            len += (i / 2) * 2;
            if(single == 0 && i % 2 == 1 )
                single = 1;
        }
        return len + single;
    }
}
