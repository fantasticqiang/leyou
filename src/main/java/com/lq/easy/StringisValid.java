package com.lq.easy;

import java.util.Stack;

/**
 * Created by lq on 2020/4/18.
 */
public class StringisValid {

    public static boolean isValid(String s) {
        if(s.equals("")) {
          return true;
        }
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c == '{') {
                stack.push('}');
            } else if(c == '(') {
                stack.push(')');
            } else if(c == '[') {
                stack.push(']');
            } else if(stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("{{{[[]]}}}");
        System.out.println(valid);
    }

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
