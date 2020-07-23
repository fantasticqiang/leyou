package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-14 13:06
 */
public class T405toHex {

    /**
     * int 转16进制字符串
     * @param args
     */
    public static void main(String[] args) {
        String s = toHex(-1);
        System.out.println(s);
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int tmp = num & 15;
            sb.append(map[tmp]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}
