package com.lq.easy;

/**
 * Created by lq on 2020/5/14.
 */
public class T11mySqrt {

    public static void main(String[] args) {
//        int i = mySqrt(1);
//        System.out.println(i);
//        int i1 = mySqrt(16);
//        System.out.println(i1);
        int i2 = mySqrt(8);
        System.out.println(i2);
    }

    /**
     * 实现 int sqrt(int x) 函数。

     计算并返回 x 的平方根，其中 x 是非负整数。

     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

     示例 1:

     输入: 4
     输出: 2

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/sqrtx
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        //x的平方根不会超过x的一半
        int right = x / 2 + 1;
        int left = 0;
        int result = -1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if((long)mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;

    }
}
