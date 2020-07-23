package com.lq.easy;

import java.util.HashMap;

public class T25majorityElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1};
        int result = majorityElement2(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int half = (nums.length + 1) / 2;
        for(int i = 0; i < nums.length; i++) {
            if( !map.containsKey(nums[i]) ){
                map.put(nums[i], 1);
            } else {
                Integer value = map.get(nums[i]);
                value += 1;
                if(value >= half) {
                    return nums[i];
                }
                map.put(nums[i], value);
            }
        }
        return nums[0];
    }

    public static int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
