package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-04 13:04
 */
public class T387firstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));

        char theDifference = findTheDifference("abcd", "abcde");
        System.out.println(theDifference);
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
     *
     * 示例：
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        for (char c : chars) {
            map[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(map[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 389. 找不同
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     *
     *  
     *
     * 示例:
     *
     * 输入：
     * s = "abcd"
     * t = "abcde"
     *
     * 输出：
     * e
     *
     * 解释：
     * 'e' 是那个被添加的字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-difference
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        char res = 0;
        int lens = s.length();
        for (int i = 0; i < lens; i++) {
            res ^= s.charAt(i)^ t.charAt(i);
        }
        res ^= t.charAt(lens);
        return res;
    }
}
