package com.lq.easy5;

import java.time.temporal.ValueRange;
import java.util.PriorityQueue;

/**
 * @author lq
 * @date 2020-07-22 11:55
 */
public class T703KthLargest {

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        T703KthLargest r = new T703KthLargest(3, nums);
        System.out.println(r.add(3));
        System.out.println(r.add(5));
        System.out.println(r.add(10));
        System.out.println(r.add(9));
    }

    private int k;

    private PriorityQueue<Integer> queue;

    public T703KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else {
            if (queue.peek() < val) {
                 queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }
}
