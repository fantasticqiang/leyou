package com.lq.easy;

/**
 * Created by lq on 2020/4/30.
 */
public class T4RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums2 = {3,2,2,3};
        int result = removeElement(nums2, 3);
        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0; //从第一个位置开始
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                continue;
            }
            nums[index] = nums[i] ;
            index++;
        }
        return index;
    }
}
