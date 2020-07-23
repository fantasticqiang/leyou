package com.lq.easy4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lq
 * @date 2020-07-09 12:43
 */
public class T572isSubtree {

    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     *
     * 示例 1:
     * 给定的树 s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 t：
     *
     *    4
     *   / \
     *  1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        boolean r = isSubtree(n1, n2);
        System.out.println(r);
    }

    public static List<Integer> l1 = new ArrayList<>();
    public static List<Integer> l2 = new ArrayList<>();
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        //s中找到t 第一个的val

        // 中序遍历
        helper(s, l1);
        helper(t, l2);
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (!l1.get(i).equals(l2.get(j))) {
                return false;
            }
            i++;
            j++;
            if (j == l2.size()) return true;
        }
        return false;
    }

    public static void helper(TreeNode node, List<Integer> l) {
        if (node != null) {
            helper(node.left, l);
            l.add(node.val);
            helper(node.right, l);
        }
    }

    public static boolean isSubtree2(TreeNode s, TreeNode t) {
        // 层序遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        List<TreeNode> r = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val == t.val) {
                r.add(pop);
            }
            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
        }
        if (r.size() ==  0) {
            return false;
        }
        for (TreeNode n : r) {
            boolean sampleTree = isSampleTree(n, t);
            if (sampleTree) return true;
        }
        return false;
    }

    public static boolean isSampleTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.val != n2.val) {
            return false;
        }
        return isSampleTree(n1.left, n2.left) && isSampleTree(n1.right, n2.right);
    }

}
