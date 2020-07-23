package com.lq.easy3;

import java.util.regex.Pattern;

/**
 * @author lq
 * @date 2020-06-29 13:07
 */
public class T520detectCapitalUse {

    /**
     * 给定一个单词，你需要判断单词的大写使用是否正确。
     *
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     *
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"leetcode"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     * 否则，我们定义这个单词没有正确使用大写字母。
     *
     * 示例 1:
     *
     * 输入: "USA"
     * 输出: True
     * 示例 2:
     *
     * 输入: "FlaG"
     * 输出: False
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(detectCapitalUse2("USA"));
        System.out.println(detectCapitalUse2("FlaG"));
        System.out.println(detectCapitalUse2("abc"));
        System.out.println(detectCapitalUse2("Abc"));
        System.out.println(detectCapitalUse2("ABc"));
    }

    public static boolean detectCapitalUse(String word) {
        boolean first = Character.isLowerCase(word.charAt(0));
        boolean last = Character.isLowerCase(word.charAt(word.length() - 1));
        if (first && last) { //首字母，尾字母都是小写
            return word.equals(word.toLowerCase());
        } else if (!first && !last) { //首字母，尾字母都是大写
            return word.equals(word.toUpperCase());
        } else {
            return word.equals(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
        }
    }

    public static boolean detectCapitalUse3(String word) {
        int upperCharCount = 0; //大写字母个数
        int upperCharIndex  = 0; //最后一个大写字母的下标index
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isUpperCase(chars[i])) {
                upperCharCount++;
                upperCharIndex = i;
            }
        }
        if (upperCharCount == word.length() || (upperCharCount == 1 && upperCharIndex == 0) || upperCharCount == 0) {
            return true;
        }
        return false;
    }

    public static boolean detectCapitalUse2(String word) {
        int upperCharCount = 0;
        int upperCharIndex  = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                upperCharCount++;
                upperCharIndex = i;
            }
        }
        if (upperCharCount == word.length() || (upperCharCount == 1 && upperCharIndex == 0) || upperCharCount == 0) {
            return true;
        }
        return false;
    }

    public static boolean detectCapitalUse4(String word) {
        return Pattern.matches("([A-Z]+)|([a-z]+)|[A-Z][a-z]+",word);
    }
}
