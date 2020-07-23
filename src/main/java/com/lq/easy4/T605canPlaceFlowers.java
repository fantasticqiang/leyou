package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-13 13:14
 */
public class T605canPlaceFlowers {

    /**
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * <p>
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     * <p>
     * 示例 1:
     * <p>
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     * 示例 2:
     * <p>
     * 输入: flowerbed = [1,0,0,0,1], n = 2
     * 输出: False
     * 注意:
     * <p>
     * 数组内已种好的花不会违反种植规则。
     * 输入的数组长度范围为 [1, 20000]。
     * n 是非负整数，且不会超过输入数组的大小。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        boolean r = canPlaceFlowers(flowerbed, 1);
        System.out.println(r);

        int[] flowerbed2 = {1, 0, 1, 0, 0};
        boolean r2 = canPlaceFlowers(flowerbed2, 1);
        System.out.println(r2);

        int[] flowerbed3 = {1, 0, 0, 0, 0, 1};
        boolean r3 = canPlaceFlowers(flowerbed3, 2);
        System.out.println(r3);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int start1 = -2; //假设在索引 -2 位置有一颗花，相当于在 -1 位置补0
        for (int i = 0; i < flowerbed.length; i++) {
            //遍历到最后 或者 某位置是1（花 ）
            //计算两个1（花）之间 0 的个数
            if (i == flowerbed.length - 1 || flowerbed[i] == 1) {
                //索引i是最后一颗花，且最后一个不是花，需要在最后补一个0
                if (i == flowerbed.length - 1 && flowerbed[i] != 1) i += 2;
                int dis = i - start1 - 1;
                start1 = i; //更新上一个花的位置
                if (dis >= 3) { //每2个空盆可以种一个花，dis - 1是确保最后两个花之间有一个空盆
                    n -= (dis - 1) / 2;
                    if (n <= 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
