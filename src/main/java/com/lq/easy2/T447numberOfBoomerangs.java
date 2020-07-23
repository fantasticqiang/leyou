package com.lq.easy2;

import java.util.HashMap;

/**
 * @author lq
 * @date 2020-06-16 20:49
 */
public class T447numberOfBoomerangs {

    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     *
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     *
     * 示例:
     *
     * 输入:
     * [[0,0],[1,0],[2,0]]
     *
     * 输出:
     * 2
     *
     * 解释:
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     * @param args
     */
    public static void main(String[] args) {
        int[][] points = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
        int i = numberOfBoomerangs2(points);
        System.out.println(i);
    }

    // 时间超出限制
    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length ; i++) {
            int[] point = points[i];
            for (int j = 0; j < points.length ; j++) {
                if(j == i) continue;
                int[] point2 = points[j];
                for (int k = 0;  k < points.length; k++) {
                    if(k ==i || k == j) continue;
                    int[] point3 = points[k];
                    if(Math.pow(point2[0] - point[0], 2) + Math.pow(point2[1] - point[1], 2) == Math.pow(point3[0] - point[0], 2) + Math.pow(point3[1] - point[1], 2)) {
                        count += 1;
                        System.out.println(point[0] + "," + point[1] + ";" + point2[0] + "," + point2[1] + ";"
                            + point3[0] + "," + point3[1]
                        );
                    }
                }
            }
        }
        return count ;
    }

    public static int numberOfBoomerangs2(int[][] points) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count = 0;
        for(int i = 0;i < points.length;i++){
            hashMap.clear();
            for(int j = 0;j < points.length;j++){
                if(i == j){
                    continue;
                }
                int distance = (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) + (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                if(hashMap.containsKey(distance)) {
                    count += hashMap.get(distance) * 2;
                    hashMap.put(distance, hashMap.get(distance) + 1);
                } else {
                    hashMap.put(distance, 1);
                }
            }
        }
        return count;
    }

}
