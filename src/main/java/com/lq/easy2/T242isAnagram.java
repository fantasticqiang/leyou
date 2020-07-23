package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-01 19:44
 */
public class T242isAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result1 = isAnagram(s, t);
        System.out.println(result1);

        String s1 = "rat";
        String t1 = "car";
        boolean result2 = isAnagram(s1, t1);
        System.out.println(result2);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
            if(map[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
