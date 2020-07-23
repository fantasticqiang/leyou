package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-03 14:09
 */
public class T344reverseString {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }

    public static void reverseString(char[] s) {
        for(int i = 0; i < s.length - 1 - i; i++) {
            char tmp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = tmp;
        }
    }
}
