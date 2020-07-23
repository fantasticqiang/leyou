package com.lq.easy;

public class T26rotate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 2;
//        rotate(nums, k);
        rotate2(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *说明:
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int m = k % nums.length;
        int[] tmpArray = new int[m];
        for(int i = 0; i < m; i++) {
            tmpArray[i] = nums[nums.length - (m - i)];
        }
        for(int j = nums.length - 1; j >= m; j--) {
            nums[j] = nums[j - m];
        }
        for(int i = 0; i < m; i++) {
            nums[i] = tmpArray[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                System.out.println(next);
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
