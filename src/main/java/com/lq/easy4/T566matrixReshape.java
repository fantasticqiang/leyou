package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-09 09:43
 */
public class T566matrixReshape {

    /**
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     *
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     *
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     *
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * 示例 1:
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = {{1, 2,3, 4}};
        int[][] r = matrixReshape(nums, 2, 2);
        for (int i = 0; i < r.length; i++) {
            int[] ints = r[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(r[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int column = nums[0].length;
        int row = nums.length;
        if (r * c != column * row) {
            return nums;
        }
        // r = 1, c = 4
        int[][] result = new int[r][c];
        for (int i = 0; i < column * row; i++) {
            result[i / c][i % c] = nums[i / column][i % column];
        }
        return result;
    }
}
