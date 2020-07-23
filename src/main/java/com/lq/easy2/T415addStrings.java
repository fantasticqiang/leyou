package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-15 09:48
 */
public class T415addStrings {

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 注意：
     *
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String s = addStrings("923", "123");
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len = Math.max(chars1.length, chars2.length);
        add(chars1, chars2, sb, 0, chars1.length - 1, chars2.length - 1);
        return sb.reverse().toString();
    }

    private static void add(char[] c1, char[] c2, StringBuilder sb, int addOne, int index1, int index2) {
        if(index1 < 0 && index2 < 0 && addOne == 0) {
            return;
        }
        int i = 0;
        if(index1 >= 0) {
            i += c1[index1] - '0';
        }
        if(index2 >= 0) {
            i += c2[index2] - '0';
        }
        i += addOne;
        sb.append(i % 10);
        index1--;
        index2--;
        if(i >= 10) {
            add(c1, c2, sb, 1, index1, index2);
        } else {
            add(c1, c2, sb, 0, index1, index2);
        }
    }
}
