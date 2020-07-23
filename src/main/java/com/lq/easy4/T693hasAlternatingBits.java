package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-20 14:22
 */
public class T693hasAlternatingBits {

    /**
     * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
     *
     * 示例 1:
     *
     * 输入: 5
     * 输出: True
     * 解释:
     * 5的二进制数是: 101
     * 示例 2:
     *
     * 输入: 7
     * 输出: False
     * 解释:
     * 7的二进制数是: 111
     * 示例 3:
     *
     * 输入: 11
     * 输出: False
     * 解释:
     * 11的二进制数是: 1011
     *  示例 4:
     *
     * 输入: 10
     * 输出: True
     * 解释:
     * 10的二进制数是: 1010
     * @param args
     */
    public static void main(String[] args) {
        boolean r = hasAlternatingBits(5);
        System.out.println(r);
        boolean r2 = hasAlternatingBits(7);
        System.out.println(r2);
    }

    public static boolean hasAlternatingBits(int n) {
        boolean flagOne =  (n ^ (n - 1)) == 1 ;
        n >>>= 1;
        while (n > 0) {
            boolean next = (n ^ (n - 1)) == 1;
            if (next == flagOne) {
                return false;
            }
            n >>>= 1;
            flagOne = next;
        }
        return true;
    }
}
