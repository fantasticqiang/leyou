package com.lq.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lq
 * @date 2020-05-30 13:11
 */
public class T225MyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int pop = myStack.pop();
        System.out.println(pop);
        int top = myStack.top();
        System.out.println(top);
        System.out.println(myStack.empty());
    }
}

class MyStack {

    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for(int i = 1; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
