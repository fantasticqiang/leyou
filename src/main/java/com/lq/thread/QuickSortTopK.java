package com.lq.thread;

/**
 * @author lq
 * @date 2020-06-09 20:42
 */
public class QuickSortTopK {
    public static void main(String[] args) {
        int array[] = {6, 5, 4, 3, 2, 1};
        int klargest = findKlargest(array, 4);
        System.out.println(klargest);
    }

    public static int findKlargest(int array[], int k) {
        k = array.length - k;
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int j = parition(array, l, r);
            if (j == k) {
                break;
            } else if (j > k) {
                r = j - 1;
            } else if (j < k) {
                l = j + 1;
            }
        }
        return array[k];
    }

    public static int parition(int array[], int l, int r) {

        int i = l;
        int j = r + 1;
        while (true) {
            while (array[++i] < array[l] && i < r) ;
            while (array[--j] > array[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
