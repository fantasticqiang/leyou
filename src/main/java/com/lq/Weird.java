package com.lq;

import com.sun.tools.javac.comp.Lower;

/**
 * Created by lq on 2019/12/25.
 */
public class Weird {

    interface IntHolder {
        int getValue();
    }

    public static void main(String[] args) {
//        IntHolder[] holders = new IntHolder[5];
//        for(int i = 0; i < 5; i++) {
//            final int fi = i;
//            class MyIntHolder implements IntHolder {
//                @Override
//                public int getValue() {
//                    return fi;
//                }
//            }
//            holders[i] = new MyIntHolder();
//        }
//        for(IntHolder holder : holders) {
//            System.out.println(holder.getValue());
//        }

        int[] array = {1, 10, 2, 20, 3, 30, 4, 40, 5, 50, 6, 60, 7, 70, 8, 80, 9, 90};
        int k = 3;

        topk(array, 0, array.length-1, k);

        for (int i = 0; i < k; i++) {
            System.out.println(array[i]);
        }

    }

    private static void topk(int[] array, int left, int right, int topk) {
        int start = left;
        int end = right;
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] <= key) {
                right--;
            }
            if(left < right) {
                array[left] = array[right];
                left++;
            }
            while (left < right && array[left] >= key) {
                left++;
            }
            if(left < right) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = key;
        if(left > topk) {
            topk(array, start, left-1, topk);
        } else if(left < topk) {
            topk(array, left+1, end, topk);
        }
    }


}
