package com.lq.easy4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lq
 * @date 2020-07-13 12:48
 */
public class T599findRestaurant {

    /**
     * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
     *
     * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
     *
     * 示例 1:
     *
     * 输入:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     * 输出: ["Shogun"]
     * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
     * 示例 2:
     *
     * 输入:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["KFC", "Shogun", "Burger King"]
     * 输出: ["Shogun"]
     * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
     * @param args
     */
    public static void main(String[] args) {
        String[] list1  = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] r = findRestaurant(list1, list2);
        Arrays.stream(r).forEach(System.out::println);

        String[] list3  = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list4 = {"KFC", "Shogun", "Burger King"};
        String[] r2 = findRestaurant(list3, list4);
        Arrays.stream(r2).forEach(System.out::println);
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;
        if (len1 > len2) {
            findRestaurant(list2, list1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < min) {
                    result.clear();
                    min = map.get(list2[i]) + i;
                    result.add(list2[i]);
                } else if (map.get(list2[i]) + i == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
