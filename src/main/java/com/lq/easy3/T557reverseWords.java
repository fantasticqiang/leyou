package com.lq.easy3;


/**
 * @author lq
 * @date 2020-07-07 11:11
 */
public class T557reverseWords {

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例 1:
     *
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc" 
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     * @param args
     */
    public static void main(String[] args) {
        String s = reverseWords("Let's take LeetCode contest");
        System.out.println(s);

        String s2 = reverseWords2("Let's take LeetCode contest");
        System.out.println(s2);

        String s3 = reverseWords3("Let's take LeetCode contest");
        System.out.println(s3);
    }

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            char[] chars = s1[i].toCharArray();
            int start = 0;
            int end = chars.length - 1;
            while (start < end) {
               char tmp = chars[end];
               chars[end] = chars[start];
               chars[start] = tmp;
               start++;
               end--;
            }
            sb.append(new java.lang.String(chars));
            if(i != s1.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            //取到空格 或者 到最后一个字符， 反转
            if (chars[i] == ' ' || i == chars.length - 1) {
                //取到最后一个字符i不需要减 1
                int end = i == chars.length - 1 ? i : i - 1;
                // 反转
                while (start < end) {
                    char tmp = chars[end];
                    chars[end] = chars[start];
                    chars[start] = tmp;
                    start++;
                    end--;
                }
                start = i + 1; //重置start下标
            }
        }
        return new String(chars);
    }

    public static String reverseWords3(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char tmp = chars[end];
            chars[end] = chars[start];
            chars[start] = tmp;
            start++;
            end--;
        }
        String[] s2 = new String(chars).split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s2.length - 1; i > 0; i--) {
            sb.append(s2[i]).append(" ");
        }
        sb.append(s2[0]);
        return sb.toString();
    }
}
