package com.lq.easy3;

/**
 * @author lq
 * @date 2020-06-19 18:22
 */
public class T461hammingDistance {

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     *
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * 上面的箭头指出了对应二进制位不同的位置。
     * @param args
     */
    public static void main(String[] args) {
        int r = hammingDistance(1, 4);
        System.out.println(r);
        int r2 = hammingDistance2(1, 4);
        System.out.println(r2);
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                distance++;
            }
            xor >>= 1;
        }
        return distance;
    }

    public static int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance++;
            xor = xor & (xor - 1); //把最后一个1改成0
        }
        return distance;
    }
}
