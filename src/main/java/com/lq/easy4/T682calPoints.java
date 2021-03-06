package com.lq.easy4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lq
 * @date 2020-07-17 18:12
 */
public class T682calPoints {

    /**
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     *
     * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
     * 你需要返回你在所有回合中得分的总和。
     *
     * 示例 1:
     *
     * 输入: ["5","2","C","D","+"]
     * 输出: 30
     * 解释:
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到2分。总和是：7。
     * 操作1：第2轮的数据无效。总和是：5。
     * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
     * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
     * 示例 2:
     *
     * 输入: ["5","-2","4","C","D","9","+","+"]
     * 输出: 27
     * 解释:
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到-2分。总数是：3。
     * 第3轮：你可以得到4分。总和是：7。
     * 操作1：第3轮的数据无效。总数是：3。
     * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
     * 第5轮：你可以得到9分。总数是：8。
     * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
     * 第7轮：你可以得到9 + 5 = 14分。总数是27。

     * @param args
     */
    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int r = calPoints(ops);
        System.out.println(r);

        String[] ops2 = {"5","2","C","D","+"};
        int r2 = calPoints(ops2);
        System.out.println(r2);

        String[] ops3 = {"4","D","D","C","D"};
        int r3 = calPoints(ops3);
        System.out.println(r3);

        String[] ops4 = {"1","D","D","D"};
        int r4 = calPoints(ops4);
        System.out.println(r4);
    }

    public static int calPoints2(String[] ops) {
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
    public static int calPoints(String[] ops) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String s : ops) {
            if ("D".equals(s)) {
                stack.push(stack.peek() * 2);
            } else if ("C".equals(s)) {
                stack.pop();
            } else if ("+".equals(s)) {
                stack.push(stack.get(0) + stack.get(1));
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.stream().mapToInt(x -> x.intValue()).sum();
    }
}
