package com.lq.easy3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lq
 * @date 2020-06-20 22:45
 */
public class T475findRadius {

    /**
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     * <p>
     * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
     * <p>
     * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
     * <p>
     * 说明:
     * <p>
     * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
     * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
     * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
     * 所有供暖器都遵循你的半径标准，加热的半径也一样。
     * 示例 1:
     * <p>
     * 输入: [1,2,3],[2]
     * 输出: 1
     * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4],[1,4]
     * 输出: 1
     * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] houses = {4, 5};
        int[] heaters = {2};
        int radius = findRadius(houses, heaters);
        System.out.println(radius);

        int[] houses2 = {1, 5};
        int[] heaters2 = {10};
        int radius2 = findRadius(houses2, heaters2);
        System.out.println(radius2);


        int[] houses3 = {1, 2, 3, 4};
        int[] heaters3 = {1, 4};
        int radius3 = findRadius(houses3, heaters3);
        System.out.println(radius3);

        int[] houses4 = {1, 2, 3};
        int[] heaters4 = {2};
        int radius4 = findRadius(houses4, heaters4);
        System.out.println(radius4);

        int[] houses5 = {1};
        int[] heaters5 = {1, 2, 3, 4};
        int radius5 = findRadius(houses5, heaters5);
        System.out.println(radius5);

        int[] houses6 = {1, 2, 3, 5, 15};
        int[] heaters6 = {2, 30};
        int radius6 = findRadius(houses6, heaters6);
        System.out.println(radius6);
    }

    public static int findRadius(int[] houses, int[] heaters) {
        // 先排序，踩坑了，以为是顺序的。
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int right = 0;
        for (int i = 0; i < houses.length; i++) {
            // 找到恰好比当前房屋大的加热器
            while (right + 1 < heaters.length && heaters[right] < houses[i]) {
                right++;
            }
            // 特判， 否则会出现越界
            if (right == 0) {
                res = Math.max(res, Math.abs(heaters[right] - houses[i]));
            } else {
                res = Math.max(res, Math.min(Math.abs(heaters[right] - houses[i]), Math.abs(houses[i] - heaters[right - 1])));
            }
        }
        return res;
    }

}
