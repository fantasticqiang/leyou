package com.lq.easy2;

import java.util.Arrays;

/**
 * @author lq
 * @date 2020-06-02 13:59
 */
public class T283moveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,0,0,3,12};
        int[] nums2 = {2, 1};
        moveZeroes2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int j  = 0;

    }

    public static void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                if(nums[j] == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                j++;
            }
        }
    }
}
