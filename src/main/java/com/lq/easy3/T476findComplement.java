package com.lq.easy3;

import java.util.Stack;

/**
 * @author lq
 * @date 2020-06-23 09:44
 */
public class T476findComplement {

    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     *
     * 示例 1:
     *
     * 输入: 5
     * 输出: 2
     * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
     * 示例 2:
     *
     * 输入: 1
     * 输出: 0
     * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
     * @param args
     */
    public static void main(String[] args) {
        int r = findComplement(1);
        System.out.println(r);
    }

    public static int findComplement(int n) {
        int result  = 0;
        int index = 0;
        while (n != 0) {
            if((n & 1) == 0) {
                result += 1 << index;
            }
            n >>= 1;
            index++;
        }
        return result;
    }
}
