package com.lq.easy;

/**
 * Created by lq on 2020/5/15.
 */
public class T15isSameTree {

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(2);
//        treeNode1.left = treeNode3;
//        TreeNode treeNode1_1 = new TreeNode(1);
//        TreeNode treeNode1_3 = new TreeNode(2);
//        treeNode1_1.left = null;
//        treeNode1_1.right = treeNode1_3;
//
//        boolean sameTree = isSameTree(treeNode1, treeNode1_1);
//        System.out.println(sameTree);

        //2-1 反转二叉树
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        TreeNode treeNode = invertTree(treeNode1);


    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //前序遍历

        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if( p.val != q.val) {
            return false;
        }
        boolean sameTree = isSameTree(p.left, q.left);
        if(sameTree == false) {
            return false;
        }
        boolean sameTree2 = isSameTree(p.right, q.right);
        if(sameTree2 == false) {
            return false;
        }
        return true;
    }

    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }
    public static void invertTreeHelper(TreeNode root) {
        if(root != null) {
            if(root.left != null || root.right != null) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                invertTreeHelper(root.left);
                invertTreeHelper(root.right);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
