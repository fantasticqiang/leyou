package com.lq;

import java.util.PriorityQueue;

/**
 * Created by lq on 2019/12/25.
 * 求前k个最小的数
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {  1, 1, 2, 3, 4, 5};
        int k = 4;
        quickSort(arr, 0, arr.length - 1, k);
        System.out.println("排序后:");
        for (int i = 0; i < k; i ++) {
            System.out.println(arr[i]);
        }


    }

    private static void quickSort(int[] array, int low, int high, int k) {
        if(low < high) {
            int index = getIndex(array, low, high);
            if(index == k) {
                return;
            }
            quickSort(array, low , index - 1, k);
            quickSort(array, index + 1, high, k);
            if(index <= k - 1) {
                return;
            }
        }
    }

    /**
     * 求中点 左边都比index小，右边都比index大
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int getIndex(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }
}
