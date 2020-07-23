package com.lq.easy4;

import java.util.Arrays;

/**
 * @author lq
 * @date 2020-07-11 17:38
 */
public class T581findUnsortedSubarray {

    /**
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     *
     * 你找到的子数组应是最短的，请输出它的长度。
     *
     * 示例 1:
     *
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 说明 :
     *
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int r = findUnsortedSubarray(nums);
        System.out.println(r);

        int r2 = findUnsortedSubarray2(nums);
        System.out.println(r2);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] sort = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(sort);
        int i = 0;
        int j = nums.length - 1;
        while (i < j && (nums[j] == sort[j] || nums[i] == sort[i])) {
            if (nums[j] == sort[j]) {
                j--;
            }
            if (nums[i] == sort[i]) {
                i++;
            }
        }
        return i == j ? 0 : j - i + 1;
    }

    public static int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }

}
