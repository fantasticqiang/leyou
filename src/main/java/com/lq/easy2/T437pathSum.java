package com.lq.easy2;

import java.util.*;

/**
 * @author lq
 * @date 2020-06-15 13:04
 */
public class T437pathSum {

    /**
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     *
     * 找出路径和等于给定数值的路径总数。
     *
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *
     * 示例：
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * 返回 3。和等于 8 的路径有:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        int i = pathSum(node1, 8);
        System.out.println(i);
        int pre = pathSum2(node1, 8);
        System.out.println(pre);

    }

    public static int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    public static int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = pathSum(root.left, sum, array, p + 1);
        int n2 = pathSum(root.right, sum, array, p + 1);
        return n + n1 + n2;
    }

    public static int pathSum2(TreeNode root, int sum) {
        List<TreeNode> pathList = new ArrayList<>();
        return pre(root, pathList, sum);
    }

    public static int pre(TreeNode node, List<TreeNode> pathList, int sum) {
        if(node == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            while (pathList.size() >= 1
                    && pathList.get(pathList.size() - 1).left != pop
                    && pathList.get(pathList.size() - 1).right != pop) {
                pathList.remove(pathList.size() - 1);
            }
            pathList.add(pop);
            // 从当前节点找 sum
            int tmp = 0;
            for (int i = pathList.size() - 1; i >= 0; i--) {
                tmp += pathList.get(i).val;
                if(tmp == sum) {
                    count++;
                }
            }
        }
        return count;
    }

}
