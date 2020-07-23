package com.lq.easy3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author lq
 * @date 2020-06-18 09:54
 */
public class T453minMoves {

    /**
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
     *
     *  
     *
     * 示例:
     *
     * 输入:
     * [1,2,3]
     *
     * 输出:
     * 3
     *
     * 解释:
     * 只需要3次移动（注意每次移动会增加两个元素的值）：
     *
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int i = minMoves(nums);
        System.out.println(i);
        int i1 = minMoves2(nums);
        System.out.println(i1);
        int i2 = minMoves3(nums);
        System.out.println(i2);
    }

    public static int minMoves(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x1, x2) -> x2 - x1);
        int min = nums[0];
        for (int x : nums) {
            queue.add(x);
            min = Math.min(x, min);
        }
        int count = 0;
        while (queue.size() >= 2) {
            Integer poll = queue.poll();
            count += poll - min;
        }
        return count;
    }

    public static int minMoves2(int[] nums) {
        int min = nums[0];
        for (int x : nums) {
            min = Math.min(min, x);
        }
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            count += nums[i] - min;
        }
        return count;
    }

    // 动态规划
    public static int minMoves3(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            count += max - min;
        }
        return count;
    }
}
