package com.lq.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lq on 2020/5/9.
 */
public class T7maxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        int i = maxSubArray2(nums);
        System.out.println(i);

        int i2 = maxSubArray2(nums2);
        System.out.println(i2);
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

     示例:

     输入: [-2,1,-3,4,-1,2,1,-5,4],
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/maximum-subarray
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     分治法
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * [-2,1,-3,4,-1,2,1,-5,4],
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int result = nums[0];
        int length = nums.length;
        int pre = 0;
        for(int i = 0; i < length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            result = Math.max(result, pre);
        }
        return result;
    }

}
