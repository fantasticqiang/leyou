package com.lq.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2020/5/19.
 */
public class T18maxProfit {

    public static void main(String[] args) {
//        int[] prices = {1, 2};
//        int result = maxProfit(prices);
//        System.out.println(result);
//        int[] prices2 = {7, 6, 4, 3, 1};
//        int result2 = maxProfit(prices2);
//        System.out.println(result2);

        int[] prices3 = {7,1,5,3,6,4};
        int result3 = maxProfit2(prices3);
        System.out.println(result3);

        int[] prices4 = {1,2,3,4,5};
        int result4 = maxProfit2(prices4);
        System.out.println(result4);
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > result) {
                result = prices[i] - minPrice;
            }
        }
        return result;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int result = 0;
        int i = 0;
        int j = 1;
        int diff = 0;
        for( ;j < prices.length; ) {
            if( prices[j] - prices[i] > 0) {
                diff += prices[j] - prices[i];
            } else {
                result += diff;
                diff = 0;
            }
            i++;
            j++;
        }
        if(diff > 0) {
            result += diff;
        }
        return result;
    }


}
