package com.lq.easy;

/**
 * @author lq
 * @date 2020-05-23 13:41
 */
public class T27reverseBits {

    public static void main(String[] args) {
        int n = -3;
        int i = hammingWeight(n);
        System.out.println(i);
    }

    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        Integer integer = Integer.valueOf(n);
        int reverse = Integer.reverse(n);
        return reverse;
    }

    public static int reverseBits2(int n) {
        int result = 0;
        int i = 32;
        while(i-- > 0) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }
        return result;
    }

    public static int hammingWeight(int n) {
        int result = 0;
        int i = 32;
        while (i-- > 0) {
            result += n & 1;
            n >>= 1;
        }
        return result;
    }
}
