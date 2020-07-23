package com.lq.easy3;

import com.lq.TreeNode;

import java.util.Stack;

/**
 * @author lq
 * @date 2020-06-30 10:08
 */
public class T530getMinimumDifference {

    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *
     * 示例：
     *
     * 输入：
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * 输出：
     * 1
     *
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.right = node3;

        int r = getMinimumDifference(node1);
        System.out.println(r);

        int r2 = getMinimumDifference2(node1);
        System.out.println(r2);
    }

    public static int getMinimumDifference(TreeNode root) {
        //中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int min = Integer.MAX_VALUE;
        TreeNode pre = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (pre != null) {
                    min = Math.min(min, Math.abs(curr.val - pre.val));
                }
                pre = curr;
                curr = curr.right;
            }
        }
        return min;
    }

    public static int getMinimumDifference2(TreeNode root) {
        inOrder(root);
        return res;
    }

    static TreeNode preNode = null;
    static int res = Integer.MAX_VALUE;
    //递归中序遍历
    public static void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);

        if(preNode != null) {
            res = Math.min(res, Math.abs(node.val - preNode.val));
        }
        preNode = node;
        inOrder(node.right);
    }
}
