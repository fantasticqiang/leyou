package com.lq.easy;

/**
 * Created by lq on 2020/5/11.
 */
public class T8lengthOfLastWord {

    public static void main(String[] args) {
        int length = lengthOfLastWord("hello world ");
        System.out.println(length);
        int length2 = lengthOfLastWord(" ");
        System.out.println(length2);
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >=0 && s.charAt(end) == ' ') end--;
        if(end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;

    }
}
