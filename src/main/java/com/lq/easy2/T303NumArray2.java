package com.lq.easy2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lq
 * @date 2020-06-03 12:59
 */
public class T303NumArray2 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        T303NumArray2 t303NumArray = new T303NumArray2(nums);
        int i = t303NumArray.sumRange(0, 2);
        int i2 = t303NumArray.sumRange(2, 5);
        int i3 = t303NumArray.sumRange(0, 5);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
    }

    int[] sums;

    public T303NumArray2(int[] nums) {
        sums = new int[nums.length + 1];
        for(Integer i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
