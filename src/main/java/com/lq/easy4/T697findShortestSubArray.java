package com.lq.easy4;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @author lq
 * @date 2020-07-22 10:00
 */
public class T697findShortestSubArray {

    public static void main(String[] args) {
        int[] nums = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        int r = findShortestSubArray(nums);
        System.out.println(r);

        int[] nums2 = {1,2,2,3,1,4,2};
        int r2 = findShortestSubArray(nums2);
        System.out.println(r2);

        int[] nums3 = {1};
        int r3 = findShortestSubArray(nums3);
        System.out.println(r3);
    }

    public static int findShortestSubArray(int[] nums) {
        // pair是一个长度为2的数组 索引位置int[0]是这个数字出现的次数，int[1]是这个数字最早出现的索引位置
        HashMap<Integer, int[]> map = new HashMap<>();
        //题中已说明：nums不为空，某个数字出现的最大次数初始值为1
        int maxCount = 1;
        // 题中已说明：nums不为空，所以最小的度是1
        int minDegree = 1;
        for (int i = 0; i < nums.length; i++) {
            //这个数字已经出现过
            if (map.containsKey(nums[i])) {
                int[] pair = map.get(nums[i]);
                // 某个数字的出现的最多次数 比 最大次数大
                if (pair[0] + 1 > maxCount) {
                    maxCount++;
                    minDegree = i - pair[1] + 1;
                }
                // 某个数字出现的次数跟最大次数相等，求min的度
                else if (pair[0] + 1 == maxCount) {
                    minDegree = Math.min(minDegree, i - pair[1] + 1);
                }
                // 出现的次数加 1
                pair[0] += 1;
            } else { //这个数字第一次出现
                // 1表示这个数字出现次数，i表示第一次出现的索引
                int[] value = {1, i};
                map.put(nums[i], value);
            }
        }
        return minDegree;
    }
}
