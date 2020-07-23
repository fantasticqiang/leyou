package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-17 17:43
 */
public class T680validPalindrome {

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * 示例 1:
     *
     * 输入: "aba"
     * 输出: True
     * 示例 2:
     *
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * 注意:
     *
     * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     * @param args
     */
    public static void main(String[] args) {
        boolean r = validPalindrome("aba");
        System.out.println(r);

        boolean r2 = validPalindrome("abca");
        System.out.println(r2);
    }

    public static boolean validPalindrome(String s) {
        if (s.length() <= 2) return true;
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return isHw(chars, i + 1, j) || isHw(chars, i, j - 1);
            }
        }
        return true;
    }

    private static boolean isHw (char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }
}
