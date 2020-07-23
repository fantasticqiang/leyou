package com.lq.easy3;

import javax.security.auth.callback.CallbackHandler;

/**
 * @author lq
 * @date 2020-07-02 09:41
 */
public class T541reverseStr {

    /**
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *  
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"

     * @param args
     */
    public static void main(String[] args) {
        String r = reverseStr("abcdefg", 2);
        System.out.println(r);

        String r2 = reverseStr2("abcdefg", 2);
        System.out.println(r2);
    }

    public static String reverseStr(String s, int k) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); ) {
            sb.setLength(0);
            while (i < s.length() && count < k) {
                sb.append(s.charAt(i));
                i++;
                count++;
            }
            result.append(sb.reverse());
            count =  0;
            while (i < s.length() && count < k) {
                result.append(s.charAt(i));
                i++;
                count++;
            }
            count = 0;
        }
        return result.toString();
    }

    public static String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //取前k个字符的坐标
            int end = Math.min(i + k - 1, chars.length - 1);
            int end2 = end;
            //前k个字符反转
            while (i < end) {
                char tmp = chars[end];
                chars[end] = chars[i];
                chars[i] = tmp;
                i++;
                end--;
            }
            //后k个字符略过
            i = Math.min(end2 + k , chars.length -1);
        }
        return new String(chars);
    }
}
