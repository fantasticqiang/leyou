package com.lq.easy2;

import java.util.PriorityQueue;

/**
 * @author lq
 * @date 2020-06-14 22:54
 */
public class T414thirdMax {

    /**
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
     * 要求算法时间复杂度必须是O(n)。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3, 2, 1]
     * <p>
     * 输出: 1
     * <p>
     * 解释: 第三大的数是 1.
     * 示例 2:
     * <p>
     * 输入: [1, 2]
     * <p>
     * 输出: 2
     * <p>
     * 解释: 第三大的数不存在, 所以返回最大的数 2 .
     * 示例 3:
     * <p>
     * 输入: [2, 2, 3, 1]
     * <p>
     * 输出: 1
     * <p>
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 3, 5};
        int i = thirdMax(nums);
        System.out.println(i);
    }

    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            //如果优先队列中含有这个数忽略，进行下一个判断
            if (queue.contains(nums[i])) {
                continue;
            }
            // queue的size小于3的时候，优先队列添加此int
            if (queue.size() < 3) {
                queue.add(nums[i]);
            } else {
                //优先队列的第一个是最小值，如果当前值比最小值大，弹出最小值，添加当前int
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        //优先队列有3个值，取第三名，不够3个取队列的最后一个（即最大值）
        return queue.size() == 3 ? queue.peek() : queue.toArray(new Integer[queue.size()])[queue.size() - 1];
    }
}
