package com.lq.easy;

import java.util.HashSet;

/**
 * @author lq
 * @date 2020-05-26 12:52
 */
public class T202isHappy {

    public static void main(String[] args) {
        boolean result = isHappy(19);
        System.out.println(result);
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

}
