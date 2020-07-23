package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-15 12:41
 */
public class T434countSegments {

    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     *
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     *
     * 示例:
     *
     * 输入: "Hello, my name is John"
     * 输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     * @param args
     */
    public static void main(String[] args) {
        int i = countSegments("love live! mu'sic forever");
        System.out.println(i);
    }

    public static int countSegments(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        boolean oneWord = false;
        for (char c : chars) {
            //根据题意，当前字符不是空格，即遇到单次了
            if(c != ' ') {
                //判断单词连续
                if (oneWord == false) {
                    oneWord = true;
                    count++;
                }
            } else { //当前单词是空格，说明一个单词结束
                oneWord = false;
            }
        }
        return count;
    }
}
