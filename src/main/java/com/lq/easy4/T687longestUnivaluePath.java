package com.lq.easy4;

/**
 * @author lq
 * @date 2020-07-20 12:52
 */
public class T687longestUnivaluePath {

    /**
     * 最长同值路径
     * <p>
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * <p>
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * <p>
     * 5
     * / \
     * 4   5
     * / \   \
     * 1   1   5
     * 输出:
     * <p>
     * 2
     * 示例 2:
     * <p>
     * 输入:
     * <p>
     * 1
     * / \
     * 4   5
     * / \   \
     * 4   4   5
     * 输出:
     * <p>
     * 2
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        int r = longestUnivaluePath(n1);
        System.out.println(max);

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        max = 0;
        int r2 = longestUnivaluePath(t1);
        System.out.println(Math.max(r2, max));

        TreeNode n31 = new TreeNode(1);
        int r3 = longestUnivaluePath(n31);
        System.out.println(r3);

    }

    public static int max = Integer.MIN_VALUE;
    public static int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int l = 0;
        int r = 0;
        if (root.left != null && root.left.val == root.val) {
            l += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            r += right + 1;
        }
        max = Math.max(max, l + r);
        return Math.max(l, r);
    }
}
