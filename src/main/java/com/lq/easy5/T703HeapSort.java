package com.lq.easy5;

import java.util.Arrays;

/**
 * @author lq
 * @date 2020-07-22 14:06
 */
public class T703HeapSort {

    /**
     * 堆排序
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1,4,5,2,3};
        int[] r = heapSort(array);
        Arrays.stream(r).forEach(System.out::println);
    }

    public static int[] heapSort(int[] array) {
        int len = array.length;
        for(int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, len);
        }
        for (int j = len - 1; j > 0; j--) {
            swap(array, 0, j);
            adjustHeap(array, 0, j);
        }
        return array;
    }

    public static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                swap(array, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
