package com.lq.easy3;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lq
 * @date 2020-06-28 12:58
 */
public class T506findRelativeRanks {

    /**
     * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
     *
     * (注：分数越高的选手，排名越靠前。)
     *
     * 示例 1:
     *
     * 输入: [5, 4, 3, 2, 1]
     * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
     * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
     * 提示:
     *
     * N 是一个正整数并且不会超过 10000。
     * 所有运动员的成绩都不相同。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        String[] res = findRelativeRanks(nums);
        for (String r : res) {
            System.out.println(r);
        }
    }

    public static String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] nums2 = Arrays.copyOf(nums, len);
        Arrays.sort(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums2[i], len - i);
        }
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) == 1) {
                res[i] = "Gold Medal";
            } else if (map.get(nums[i]) == 2) {
                res[i] = "Silver Medal";
            } else if (map.get(nums[i]) == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = map.get(nums[i]) + "";
            }
        }
        return res;
    }
}
