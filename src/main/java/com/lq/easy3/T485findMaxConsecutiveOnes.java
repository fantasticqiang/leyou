package com.lq.easy3;

/**
 * @author lq
 * @date 2020-06-27 11:20
 */
public class T485findMaxConsecutiveOnes {

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     *
     * 示例 1:
     *
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * 注意：
     *
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int[] nums2 = {0,0,0,1,1,1};
        int[] nums3 = {0,0,0};
        System.out.println(findMaxConsecutiveOnes(nums));
        System.out.println(findMaxConsecutiveOnes(nums2));
        System.out.println(findMaxConsecutiveOnes(nums3));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                tmp++;
                if(i < nums.length - 1) {
                    continue;
                }
            }
            if (nums[i] == 0 || i == nums.length - 1) {
                if (tmp != 0) {
                    max = Math.max(max, tmp);
                    tmp = 0;
                }
            }
        }
        return max;
    }
}
