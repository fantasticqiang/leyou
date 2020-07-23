package com.lq.easy2;

import java.util.HashSet;

/**
 * @author lq
 * @date 2020-06-03 19:17
 */
public class T345reverseVowels {

    public static void main(String[] args) {
        String s = "hello";
        String result = reverseVowels(s);
        System.out.println(result);

        String result2 = reverseVowels2(s);
        System.out.println(result2);
    }

    public static String reverseVowels(String s) {
        HashSet<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('A');
        characters.add('e');
        characters.add('E');
        characters.add('i');
        characters.add('I');
        characters.add('o');
        characters.add('O');
        characters.add('u');
        characters.add('U');
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j;) {
            while (i < chars.length - 1 && !characters.contains(chars[i])) {
                i++;
            }
            while (j >=0 && !characters.contains(chars[j])) {
                j--;
            }
            if(i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public static String reverseVowels2(String s) {
        HashSet<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('A');
        characters.add('e');
        characters.add('E');
        characters.add('i');
        characters.add('I');
        characters.add('o');
        characters.add('O');
        characters.add('u');
        characters.add('U');
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j;) {
            if(characters.contains(chars[i]) ) {
                if(characters.contains(chars[j])) {
                    if(chars[i] != chars[j]) {
                        char tmp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = tmp;
                    }
                    i++;
                    j--;
                } else {
                    j--;
                }

            } else {
                i++;
            }
        }
        return String.valueOf(chars);
    }
}
