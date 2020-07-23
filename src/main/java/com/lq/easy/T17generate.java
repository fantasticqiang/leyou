package com.lq.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lq on 2020/5/18.
 */
public class T17generate {

    public static void main(String[] args) {
//        List<List<Integer>> result = generate(5);
//        result.stream().forEach(x -> System.out.println(String.join(",", String.valueOf(x))));

        List<Integer> result = getRow(4);
        System.out.println(String.join(",", result.stream().map(x -> String.valueOf(x)).collect(Collectors.toList())));
    }

    /**
     * 杨辉三角
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }
        for(int i = 0; i < numRows; i++) {
            ArrayList<Integer> tmp = new ArrayList<>(i + 1);
            List<Integer> pre = null;
            if(i - 1 >= 0) {
                pre = result.get(i - 1);
            }
            for(int j = 0 ; j <= i; j++) {
                if(j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(pre.get(j - 1) + pre.get(j));
                }
            }
            result.add(tmp);
        }
        return result;
    }

    /**
     * 求第k行的list
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            result.add(i, 1); //最后一个数为1
            for(int j = i - 1; j >= 1; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
        }
        return result;
    }
}
