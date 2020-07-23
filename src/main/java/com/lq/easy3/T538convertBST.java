package com.lq.easy3;

import com.lq.TreeNode;

/**
 * @author lq
 * @date 2020-07-01 19:28
 */
public class T538convertBST {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        convertBST(node1);

    }

    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
     * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     * 例如：
     *
     * 输入: 原始二叉搜索树:
     *               5
     *             /   \
     *            2     13
     *
     * 输出: 转换为累加树:
     *              18
     *             /   \
     *           20     13
     * @param root
     * @return
     */
    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        //反序 中序遍历
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
