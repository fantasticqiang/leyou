package com.lq.easy;

import java.util.Arrays;

/**
 * Created by lq on 2020/4/23.
 */
public class T3RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }

    /**
     * 数组是排号序的，返回不重复的数组长度，数组改为不重复的
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int tmp = nums[0];
        int index = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == tmp) {
                continue;
            }
            nums[index] = nums[i];
            tmp = nums[i];
            index++;
        }
        return index;
    }
}
