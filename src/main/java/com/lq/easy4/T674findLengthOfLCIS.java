package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-17 17:21
 */
public class T674findLengthOfLCIS {

    /**
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [1,3,5,4,7]
     * 输出: 3
     * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
     * 示例 2:
     *
     * 输入: [2,2,2,2,2]
     * 输出: 1
     * 解释: 最长连续递增序列是 [2], 长度为1。
     *  
     *
     * 注意：数组长度不会超过10000。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int r = findLengthOfLCIS(nums);
        System.out.println(r);

        int r3 = findLengthOfLCIS2(nums);
        System.out.println(r3);

        int[] nums2 = {2,2,2,2,2};
        int r2 = findLengthOfLCIS(nums2);
        System.out.println(r2);

    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length < 1) return nums.length;
        int r = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
            } else {
                r = Math.max(r, count);
                count = 1;
            }
        }
        return Math.max(r, count);
    }

    public static int findLengthOfLCIS2(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

}
