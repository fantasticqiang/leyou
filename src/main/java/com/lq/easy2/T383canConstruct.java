package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-04 12:54
 */
public class T383canConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "aab"));
    }

    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
     * 如果可以构成，返回 true ；否则返回 false。
     *
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     * 注意：
     *
     * 你可以假设两个字符串均只含有小写字母。
     *
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] map = new int[26];
        char[] chars1 = magazine.toCharArray();
        for (char c : chars1) {
            map[c - 'a'] = map[c - 'a'] + 1;
        }
        char[] chars2 = ransomNote.toCharArray();
        for (char c : chars2) {
            if(map[c - 'a'] == 0) {
                return false;
            }
            map[c - 'a'] = map[c - 'a'] - 1;
        }
        return true;
    }
}
