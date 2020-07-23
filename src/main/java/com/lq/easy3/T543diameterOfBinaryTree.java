package com.lq.easy3;

import com.lq.TreeNode;

/**
 * @author lq
 * @date 2020-07-02 18:09
 */
public class T543diameterOfBinaryTree {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     *
     *  
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
        int r = diameterOfBinaryTree(n1);
        System.out.println(r);
    }

    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return max;
    }

    private static int getHeight(TreeNode root) {
        if (root == null ) return 0;
        int lh = root.left == null ? 0 : getHeight(root.left) + 1;
        int rh = root.right == null ? 0 : getHeight(root.right) + 1;
        max = Math.max(max, lh + rh);
        return Math.max(lh, rh);
    }

}
