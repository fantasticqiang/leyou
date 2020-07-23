package com.lq.easy2;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author lq
 * @date 2020-06-04 13:32
 */
public class T392isSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        testJava8Sort();
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     *
     * 返回 true.
     *
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     *
     * 返回 false
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] == chars2[j]) {
                i++;
            }
            j++;

        }
        return i == chars1.length;
    }

    public static void testJava8Sort() {
        Person p1 = new Person("p1", 1);
        Person p2 = new Person("p2", 2);
        Person p3 = new Person("p3", 3);
        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.sort((a, b) -> (int) (b.count - a.count));
        for (Person p : people) {
            System.out.println(p.key + ":" + p.count);
        }

    }

    static class Person {
        private String key;

        private long count;

        public Person(String key, long count) {
            this.key = key;
            this.count = count;
        }
    }
}
