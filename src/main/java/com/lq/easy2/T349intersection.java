package com.lq.easy2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lq
 * @date 2020-06-03 19:37
 */
public class T349intersection {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
//        int[] result = intersection(nums1, nums2);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

        int[] result2 = intersect(nums1, nums2);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int len = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < len; i++) {
            if (i < nums1.length) {
                set1.add(nums1[i]);
            }
            if (i < nums2.length) {
                set2.add(nums2[i]);
            }
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (Integer item : set1) {
            result[i++] = item.intValue();
        }
        return result;
    }

    /**
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                nums1[k++] = n;
                map.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
