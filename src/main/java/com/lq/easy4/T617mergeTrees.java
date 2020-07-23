package com.lq.easy4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lq
 * @date 2020-07-16 09:54
 */
public class T617mergeTrees {

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     *
     * 示例 1:
     *
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * 注意: 合并必须从两个树的根节点开始。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(1);
        TreeNode n23 = new TreeNode(3);
        TreeNode n24 = new TreeNode(4);
        TreeNode n25 = new TreeNode(7);
        n21.left = n22;
        n21.right = n23;
        n22.right = n24;
        n23.right = n25;
        TreeNode treeNode = mergeTrees(n1, n21);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.println(pop.val);
            if (pop.left != null) queue.add(pop.left);
            if (pop.right != null) queue.add(pop.right);
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t1);
        stack.push(t2);
        TreeNode result = new TreeNode(0);
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(result);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            int tmp1 = n1 == null ? 0 : n1.val;
            int tmp2 = n2 == null ? 0 : n2.val;
            TreeNode pop = stack2.pop();
            pop.val = tmp1 + tmp2;
            if ((n1 != null && n1.left != null) || (n2 != null && n2.left != null)) {
                stack.push(n1 == null ? null : n1.left);
                stack.push(n2 == null ? null : n2.left);
                TreeNode left = new TreeNode(0);
                pop.left = left;
                stack2.push(left);
            }
            if ((n1 != null && n1.right != null) || (n2 != null && n2.right != null)) {
                stack.push(n1 == null ? null : n1.right);
                stack.push(n2 == null ? null : n2.right);
                TreeNode right = new TreeNode(0);
                pop.right = right;
                stack2.push(right);
            }
        }
        return result;
    }

    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
