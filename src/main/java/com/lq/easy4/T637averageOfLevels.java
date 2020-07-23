package com.lq.easy4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lq
 * @date 2020-07-16 12:57
 */
public class T637averageOfLevels {

    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        List<Double> r = averageOfLevels(n1);
        r.stream().forEach(System.out::println);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            result.add((double) sum / size);
        }
        return result;
    }
}
