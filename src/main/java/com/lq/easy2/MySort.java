package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-09 17:00
 */
public class MySort {

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 2, 6};
        maoPao(nums);
    }

    public static void maoPao(int[] nums) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    //交换
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);
        }
    }
}
