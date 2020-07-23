package com.lq.easy3;

/**
 * @author lq
 * @date 2020-06-28 12:43
 */
public class T504convertToBase7 {

    /**
     * int 转7进制数
     *
     * @param args
     */
    public static void main(String[] args) {
        String r = convertToBase7(-7);
        System.out.println(r);
    }


    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            num = -num;
            flag = true;
        }
        while (num != 0) {
            int mod = num % 7;
            sb.append((char) ('0' + mod));
            num = num / 7;
        }
        return flag == true ? "-" + sb.reverse().toString() : sb.reverse().toString();
    }
}
