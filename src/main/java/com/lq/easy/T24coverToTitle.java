package com.lq.easy;

/**
 * Created by lq on 2020/5/21.
 */
public class T24coverToTitle {

    public static void main(String[] args) {
        String s = coverToTitle(701);
        System.out.println(s);
        int i = titleToNumber(s);
        System.out.println(i);
        int i2 = titleToNumber2(s);
        System.out.println(i2);
    }

    public static String coverToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n -= 1;
            sb.append(Character.valueOf((char) ('A' + (n % 26))));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public static int titleToNumber(String s) {
        int len = s.length();
        int result = 0;
        for(int i = 0; i < len; i++) {
            int num = s.charAt(i) - 'A';
            result +=  (int) Math.pow(26, len - i - 1) * (num + 1);
        }
        return result;
    }

    public static int titleToNumber2(String s) {
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            int num = s.charAt(i) - 'A';
            result = result * 26 + num + 1;
        }
        return result;
    }
}
