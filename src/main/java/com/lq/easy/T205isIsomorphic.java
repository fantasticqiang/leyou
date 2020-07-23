package com.lq.easy;

import java.util.HashMap;

/**
 * @author lq
 * @date 2020-05-28 10:25
 */
public class T205isIsomorphic {

    public static void main(String[] args) {
        boolean r1 = isIsomorphic("egga", "addf");
        System.out.println(r1);

        boolean isomorphic2 = isIsomorphic2("egga", "addf");
        System.out.println(isomorphic2);

        boolean b = isomorphic3("egga", "addf");
        System.out.println(b);

    }

    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 示例 1:
     *
     * 输入: s = "egg", t = "add"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "foo", t = "bar"
     * 输出: false
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphicHelper(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 != len2) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < len1; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)) {
                if(map.get(c1) != c2) {
                    return false;
                }
            }else {
                map.put(c1, c2);
            }

        }
        return true;
    }

    /**
     * 第二种解法
     * ab, aa
     */
    public static boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if(map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        return true;
    }

    public static boolean isomorphic3(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                //if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                //}
            }
        }
        return true;
    }
}
