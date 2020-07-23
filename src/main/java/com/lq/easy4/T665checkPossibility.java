package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-17 10:51
 */
public class T665checkPossibility {

    /**
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     *
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     *
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-1,4,2,3};
        boolean r = checkPossibility(nums);
        System.out.println(r);

        int[] nums2 = {4,2,3};
        boolean r2 = checkPossibility(nums2);
        System.out.println(r2);

        int[] nums3 = {3,4,2,3};
        boolean r3 = checkPossibility(nums3);
        System.out.println(r3);

        int[] nums4 = {1,2,5,3,3};
        boolean r4 = checkPossibility(nums4);
        System.out.println(r4);
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int count = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            count++;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= nums[i-1]) {
                continue;
            }
            count++;
            if (count >= 2) {
                return false;
            }
            if (nums[i-2] <= nums[i]) {
                nums[i-1] = nums[i-2];
            } else {
                nums[i] = nums[i-1];
            }
        }
        return true;
    }
}
