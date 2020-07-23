package com.lq.easy;

/**
 * Created by lq on 2020/5/9.
 */
public class T6searchInsert {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};

        int target2 = 5;
        int i1 = searchInsert(nums, target2);
        System.out.println(i1);
        int target3 = 2;
        int i3 = searchInsert(nums, target3);
        System.out.println(i3);
        int target = 7;
        int i = searchInsert(nums, target);
        System.out.println(i);
        int target4 = 0;
        int i4 = searchInsert(nums, target4);
        System.out.println(i4);
    }

    public static int searchInsert(int[] nums, int target) {
        //二分法找到插入位置
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if(nums[middle] == target) {
                return middle;
            }else if(nums[middle] < target) {
                low = middle + 1;
            } else if(nums[middle] > target) {
                high = middle - 1;
            }
        }
        return low;
    }
}
