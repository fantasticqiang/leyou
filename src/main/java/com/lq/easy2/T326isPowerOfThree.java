package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-03 13:20
 */
public class T326isPowerOfThree {

    public static void main(String[] args) {

    }

    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     *
     * 示例 1:
     *
     * 输入: 27
     * 输出: true
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
