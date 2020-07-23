package com.lq.mid;

import javafx.util.Pair;

import java.util.*;
import java.util.logging.Level;

/**
 * @author lq
 * @date 2020-06-14 19:18
 */
public class T102levelOrder {

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *  
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> r = levelOrder(node1);
        for (List<Integer> t : r) {
            t.forEach(x -> System.out.print(x + ", "));
            System.out.println("------");
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        if(root != null) {
            queue.add(new Pair<>(root, 1));
        }
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> first = queue.poll();
            TreeNode node = first.getKey();
            Integer level = first.getValue();
            List<Integer> tmp = null;
            if (result.size() >= level) {
                tmp = result.get(level - 1);
            } else {
                tmp = new ArrayList<>();
                result.add(tmp);
            }
            tmp.add(node.val);
            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
        }
        return result;
    }

}
