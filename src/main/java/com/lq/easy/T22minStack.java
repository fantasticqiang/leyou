package com.lq.easy;

import java.util.Stack;

/**
 * Created by lq on 2020/5/20.
 */
public class T22minStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.pop();
        minStack.push(6);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.push(1);
        int top = minStack.top();
        System.out.println(top);
    }

    static class MinStack {

        private Stack<Integer> data;

        private Stack<Integer> helper;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            data.add(x);
            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            } else {
                helper.add(helper.peek());
            }
        }

        public void pop() {
            if (!data.isEmpty()) {
                data.pop();
                helper.pop();
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }
            throw new RuntimeException("栈为空");
        }

        public int getMin() {
            if(!helper.isEmpty()) {
                return helper.peek();
            }
            throw new RuntimeException("栈为空");
        }
    }
}
