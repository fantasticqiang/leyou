package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-02 09:57
 */
public class T258addDigits {

    public static void main(String[] args) {
        int i = addDigits(38);
        System.out.println(i);
    }

    public static int addDigits(int num) {
        int i = calSum(num);
        while (i >= 10) {
            i = calSum(i);
        }
        return i;
    }

    private static int calSum(int num) {
        int sum = 0;
        while (num / 10 > 0) {
            sum += num % 10;
            num = num / 10;
        }
        sum += num;
        return sum;
    }
}
