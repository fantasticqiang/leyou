package com.lq.easy4;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lq
 * @date 2020-07-17 13:07
 */
public class T669trimBST {

    /**
     * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
     * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
     *
     * 示例 1:
     *
     * 输入:
     *     1
     *    / \
     *   0   2
     *
     *   L = 1
     *   R = 2
     *
     * 输出:
     *     1
     *       \
     *        2
     * 示例 2:
     *
     * 输入:
     *     3
     *    / \
     *   0   4
     *    \
     *     2
     *    /
     *   1
     *
     *   L = 1
     *   R = 3
     *
     * 输出:
     *       3
     *      /
     *    2
     *   /
     *  1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n4.left = n5;

        TreeNode r = trimBST(n1, 1, 3);
        System.out.println("---");
    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static TreeNode trimBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode result = null;
        //找到第一个在区间内的node
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val >= L && poll.val <= R) {
                result = poll;
                break;
            }
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        if (result == null) return null;
        queue.clear();
        queue.add(result);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll.left != null) {
                if (poll.left.val < L) {

                }
            }
        }
        return null;
    }

}
