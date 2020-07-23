package com.lq.easy3;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author lq
 * @date 2020-07-01 10:15
 */
public class T532findPairs {

    /**
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
     * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     *
     * 示例 1:
     *
     * 输入: [3, 1, 4, 1, 5], k = 2
     * 输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * 示例 2:
     *
     * 输入:[1, 2, 3, 4, 5], k = 1
     * 输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 示例 3:
     *
     * 输入: [1, 3, 1, 5, 4], k = 0
     * 输出: 1
     * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,9,0,8,9,6,5,9,8,1,9,6,9,2,8,8,7,5,7,8,8,3,7,4,1,1,6,2,9,9,3,9,2,4,6,5,6,5,1,5,9,9,8,1,4,3,2,8,5,3,5,4,5,7,0,0,7,6,4,7,2,4,9,3,6,6,5,0,0,0,8,9,9,6,5,4,6,2,1,3,2,5,0,1,4,2,6,9,5,4,9,6,0,8,3,8,0,0,2,1};
        int k = 1;
        int r = findPairs(nums, k);
        int r12 = findPairs2(nums, k);
        System.out.println(r);
        System.out.println(r12);

        int[] nums2 = {1, 3, 1, 5, 4};
        int k2 = 0;
        int r2 = findPairs(nums2, k2);
        int r22 = findPairs2(nums2, k2);
        System.out.println(r2);
        System.out.println(r22);

        int[] nums3 = {1, 1, 1, 1, 1};
        int k3 = 0;
        int r3 = findPairs2(nums3, k3);
        System.out.println(r3);

        int[] nums4 = {3, 1, 4, 1, 5};
        int k4 = 2;
        int r4 = findPairs2(nums4, k4);
        System.out.println(r4);
    }

    public static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k && !set.contains(nums[i] + nums[j])) {
                    count++;
                    set.add(nums[i] + nums[j]);
                }
            }
        }
        return count;
    }

    public static int findPairs2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Arrays.sort(nums); //排序
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //找到相同数的最后一个，比如 1，1，1，1 找到最后一个1的坐标
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
            //如果k为0这种情况，跟前一个数比较
            if (k == 0 ) {
                if (i - 1 >= 0 && nums[i] == nums[i-1]) {
                    count++;
                }
                continue;
            }
            //k不为0，跟下一个比较
//            int j = i + 1;
//            while (j < nums.length) {
//                if (nums[j] - nums[i] > k) break; //因为递增序列，大于k的时候后面不用找了
//                if (i + 1 < nums.length && nums[j] - nums[i] == k) { //找到绝对值相差k的值
//                    count++;
//                    break;
//                }
//                j++;
//            }
            int next = binarySearch(nums, i, nums.length - 1, nums[i] + k);
            if (next != -1) {
                count++;
            }
        }
        return count;
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


}
