package com.lq.easy3;

/**
 * @author lq
 * @date 2020-06-29 12:46
 */
public class T509fib {

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int f1 = 0;
        int f2 = 1;
        int index = 2; //从f(2)开始
        int sum = 0;
        while (index <= N) {
            //求f(2), f(3), f(4) ...f(N)
            sum = f1 + f2;
            f1 = f2; // f1变成f2
            f2 = sum; // f2变成sum
            index++; //求下一个
        }
        return sum;
    }
}
