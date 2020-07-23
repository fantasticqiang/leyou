package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-04 09:47
 */
public class T371getSum {

    public static void main(String[] args) {
        int sum = getSum(1, 2);
        System.out.println(sum);
    }

    /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     *
     * 示例 1:
     *
     * 输入: a = 1, b = 2
     * 输出: 3

     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
