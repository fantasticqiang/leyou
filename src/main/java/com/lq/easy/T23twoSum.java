package com.lq.easy;

/**
 * Created by lq on 2020/5/21.
 */
public class T23twoSum {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

     函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

     说明:

     返回的下标值（index1 和 index2）不是从零开始的。
     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     示例:

     输入: numbers = [2, 7, 11, 15], target = 9
     输出: [1,2]
     解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int start = 1;
        int end = numbers.length;
        int[] result = new int[2];
        while (start < end) {
            int sum = numbers[start - 1] + numbers[end - 1];
            if(sum == target) {
                result[0] = start;
                result[1] = end;
                break;
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
