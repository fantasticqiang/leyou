package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-16 13:08
 */
public class T643findMaxAverage {

    /**
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 示例 1:
     *
     * 输入: [1,12,-5,-6,50,3], k = 4
     * 输出: 12.75
     * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     *  
     *
     * 注意:
     *
     * 1 <= k <= n <= 30,000。
     * 所给数据范围 [-10,000，10,000]。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0,1,1,3,3};
        double r = findMaxAverage(nums, 4);
        System.out.println(r);
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum  = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(sum, res);
        }
        return res / k;
    }
}
