package com.lq.easy2;

/**
 * @author lq
 * @date 2020-06-13 09:36
 */
public class T404sumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node6 = new TreeNode(-1);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node6;
        node3.left = node4;
        node3.right = node5;
        int i = sumOfLeftLeaves(node1);
        System.out.println(i);
        int i1 = sumOfLeftLeaves2(node1);
        System.out.println(i1);
    }

    public static int sumOfLeftLeaves (TreeNode treeNode) {
        int[] sum = {0};
        leftSum(treeNode, sum, false);
        return sum[0];
    }

    private static void leftSum (TreeNode treeNode, int[] sum, boolean left) {
        if(treeNode != null) {
            if(left == true && treeNode.left == null && treeNode.right == null) {
                sum[0] += treeNode.val;
            }
            leftSum(treeNode.left, sum, true);
            leftSum(treeNode.right, sum, false);
        }
    }

    public static int sumOfLeftLeaves2(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        if(treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) {
            return sumOfLeftLeaves2(treeNode.right) + treeNode.left.val;
        }
        return sumOfLeftLeaves2(treeNode.left) + sumOfLeftLeaves2(treeNode.right);
    }
}
