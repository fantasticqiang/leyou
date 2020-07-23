package com.lq.easy2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author lq
 * @date 2020-06-02 19:29
 */
public class T290wordPattern {

    public static void main(String[] args) {
        String pattern = "aba";
        String str = "dog cat cat";
        boolean result = wordPattern(pattern, str);
        System.out.println(result);
    }

    public static boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] s = str.split(" ");
        if(chars.length != s.length) {
            return false;
        }
        int n = chars.length;
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char a = chars[i];
            String b = s[i];
            if(map.containsKey(a)) {
                if(!map.get(a).equals(b)){
                    return false;
                }
            } else {
                if(map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }
        }
        return true;
    }
}
