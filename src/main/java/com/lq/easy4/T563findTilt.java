package com.lq.easy4;

import com.lq.TreeNode;

import java.util.Stack;

/**
 * @author lq
 * @date 2020-07-08 17:07
 */
public class T563findTilt {

    /**
     * 给定一个二叉树，计算整个树的坡度。
     *
     * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
     *
     * 整个树的坡度就是其所有节点的坡度之和。
     *
     *  
     *
     * 示例：
     *
     * 输入：
     *          1
     *        /   \
     *       2     3
     * 输出：1
     * 解释：
     * 结点 2 的坡度: 0
     * 结点 3 的坡度: 0
     * 结点 1 的坡度: |2-3| = 1
     * 树的坡度 : 0 + 0 + 1 = 1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        int r = findTilt(n1);
        System.out.println(r);

        int r2 = findTilt2(n1);
        System.out.println(r2);
    }


    public static int findTilt(TreeNode root) {
        if(root == null) return 0;
        //层序遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            int l = pop.left == null ? 0 : pop.left.val;
            int r = pop.right == null ? 0 : pop.right.val;
            sum += Math.abs(l - r);
            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
        }
        return sum;
    }

    public static int sum = 0;
    public static int findTilt2(TreeNode root) {
        helper(root);
        return sum;
    }

    //递归
    public static int helper(TreeNode root) {
        if (root == null) return 0;
        int l2 = helper(root.left);
        int r2 = helper(root.right);
        sum += Math.abs(l2 - r2);
        return l2 + r2 + root.val;
    }
}
