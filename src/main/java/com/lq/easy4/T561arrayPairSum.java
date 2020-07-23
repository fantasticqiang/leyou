package com.lq.easy4;

import java.util.Arrays;

/**
 * @author lq
 * @date 2020-07-08 12:54
 */
public class T561arrayPairSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2};
        int r = arrayPairSum(nums);
        System.out.println(r);

        int r2 = arrayPairSum2(nums);
        System.out.println(r2);

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public static int arrayPairSum2(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }
}
