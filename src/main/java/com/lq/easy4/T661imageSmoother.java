package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-17 09:46
 */
public class T661imageSmoother {

    /**
     * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
     * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
     *
     * 示例 1:
     *
     * 输入:
     * [[1,1,1],
     *  [1,0,1],
     *  [1,1,1]]
     * 输出:
     * [[0, 0, 0],
     *  [0, 0, 0],
     *  [0, 0, 0]]
     * 解释:
     * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
     * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
     * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
     * @param args
     */
    public static void main(String[] args) {
        int[][] M  = {{2,3,4}, {5,6,7}, {8,9,10}, {11,12,13}, {14,15,16}};
        int[][] r = imageSmoother(M);
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[0].length; j++) {
                System.out.print(r[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] r = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                int count = 1;
                sum += M[i][j];
                if (i - 1 >= 0) {
                    sum += M[i-1][j];
                    count++;
                }
                if(j - 1 >= 0) {
                    sum += M[i][j-1];
                    count++;
                }
                if (i - 1 >= 0 && j - 1 >=0) {
                    sum += M[i-1][j-1];
                    count++;
                }
                if (i + 1 < row) {
                    sum += M[i+1][j];
                    count++;
                }
                if (j + 1 < col) {
                    sum += M[i][j+1];
                    count++;
                }
                if (i + 1 < row && j - 1 >= 0) {
                    sum += M[i+1][j-1];
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < col) {
                    sum += M[i-1][j+1];
                    count++;
                }
                if (i + 1 < row && j + 1 < col) {
                    sum += M[i+1][j+1];
                    count++;
                }
                r[i][j] = sum / count;
            }
        }
        return r;
    }

    public static int[][] imageSmoother2(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r-1; nr <= r+1; ++nr)
                    for (int nc = c-1; nc <= c+1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }
}