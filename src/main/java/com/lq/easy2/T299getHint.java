package com.lq.easy2;

import java.util.Arrays;

/**
 * @author lq
 * @date 2020-06-03 09:37
 */
public class T299getHint {

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        String hint = getHit(secret, guess);
        System.out.println(hint);
        String hint2 = getHit2(secret, guess);
        System.out.println(hint2);
    }

    /**
     * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
     * <p>
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     * <p>
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     * <p>
     * 示例 1:
     * <p>
     * 输入: secret = "1807", guess = "7810"
     * <p>
     * 输出: "1A3B"
     * <p>
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     *
     * @param secret
     * @param guess
     * @return
     */
    public static String getHit(String secret, String guess) {
        char[] chars = guess.toCharArray();
        char[] chars1 = secret.toCharArray();
        int countA = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars1[i]) {
                //统计对应位置完全相等的个数
                countA++;
            }
        }
        Arrays.sort(chars);
        Arrays.sort(chars1);
        int countB = 0;
        //统计位置相等或者不等数字相同的个数
        for (int i = 0, j = 0; i < chars.length && j < chars.length; ) {
            if (chars[i] < chars1[j]) {
                i++;
            } else if (chars[i] > chars1[j]) {
                j++;
            } else if (chars[i] == chars1[j]) {
                countB++;
                i++;
                j++;
            }
        }
        countB = countB - countA;
        return countA + "A" + countB + "B";
    }

    public static String getHit2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) bulls++;
            else {
                //当前数小于 0, 说明之前在 guess 中出现过, 和 secret 当前的数匹配
                if (numbers[s] < 0) cows++;
                //当前数大于 0, 说明之前在 secret 中出现过, 和 guess 当前的数匹配
                if (numbers[g] > 0) cows++;
                //secret 中的数, 计数加 1
                numbers[s] ++;
                //guess 中的数, 计数减 1
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
