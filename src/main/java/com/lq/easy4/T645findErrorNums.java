package com.lq.easy4;

import java.util.HashSet;

/**
 * @author lq
 * @date 2020-07-16 14:09
 */
public class T645findErrorNums {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] r = findErrorNums(nums);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }

    public static int[] findErrorNums(int[] nums) {
        long sum = 0;
        int d = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (d == 0) {
                if(set.contains(nums[i])) {
                    d = nums[i];
                } else {
                    set.add(nums[i]);
                }
            }
        }
        long total = (nums.length + 1) * nums.length  / 2;
        int[] r = new int[2];
        r[0] = d;
        r[1] = (int) (d + total - sum);
        return r;
    }

    public static int[] findErrorNums2(int[] nums) {
        int[] counter = new int[nums.length+1];
        for (int i: nums) {
            counter[i]++;
        }
        int[] result = new int[2];
        for (int i = 1; i<counter.length; i++) {
            if (counter[i] == 0) {
                result[1] = i;
            } else if (counter[i] == 2) {
                result[0] = i;
            }
        }
        return result;
    }
}
