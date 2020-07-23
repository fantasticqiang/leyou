package com.lq.easy;

/**
 * Created by lq on 2020/5/13.
 */
public class T10addBinary {

    public static void main(String[] args) {
//        String s = addBinary("11", "1");
//        System.out.println(s);
        String s1 = addBinary("1111", "1111");
        System.out.println(s1);
    }

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。

     输入为 非空 字符串且只包含数字 1 和 0。

      

     示例 1:

     输入: a = "11", b = "1"
     输出: "100"

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/add-binary
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int max = Math.max(lengthA, lengthB);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < max; i++) {
            int sum = 0;
            if(i < lengthA) {
                sum +=  a.charAt(lengthA - 1 - i) - '0';
            }
            if(i < lengthB) {
                sum += b.charAt(lengthB - 1 - i) - '0';
            }
            if(sb.length() > i ) {
                sum++;
            }
            if(sum == 3) {
                if(sb.length() > i) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.append("1");
                }
                sb.append("1");
            } else if(sum == 2 ) {
                if(sb.length() > i) {
                    sb.setCharAt(i, '0');
                } else {
                    sb.append("0");
                }
                sb.append("1");
            } else if(sum == 1) {
                if(sb.length() > i ) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.append("1");
                }
            } else {
                sb.append("0");
            }

        }
        return sb.reverse().toString();
    }
}
