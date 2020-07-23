package com.lq.easy2;

import javax.swing.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lq
 * @date 2020-06-13 10:42
 */
public class T655printTree {

    /**
     * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
     *
     * 行数 m 应当等于给定二叉树的高度。
     * 列数 n 应当总是奇数。
     * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
     * 每个未使用的空间应包含一个空的字符串""。
     * 使用相同的规则输出子树。
     * 示例 1:
     *
     * 输入:
     *      1
     *     /
     *    2
     * 输出:
     * [["", "1", ""],
     *  ["2", "", ""]]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        List<List<String>> lists = printTree(node1);
        lists.stream().forEach(x -> {
            System.out.println(String.join(",", x));
        });
    }

    public static List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }
        ArrayList<List<String>> result = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] tmp : res) {
            result.add(Arrays.asList(tmp));
        }
        return result;
    }

    public static void fill(String[][] res, TreeNode node, int level, int l, int r) {
        if(node == null) {
            return;
        }
        int mid = (l + r) / 2;
        res[level][mid] = node.val + "";
        fill(res, node.left, level + 1, l , mid);
        fill(res, node.right, level + 1, mid + 1, r);
    }

    // 求二叉树的高度
    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
