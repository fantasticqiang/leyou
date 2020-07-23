package com.lq.easy4;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author lq
 * @date 2020-07-17 16:30
 */
public class T671findSecondMinimumValue {

    /**
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
     * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     * <p>
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * 2
     * / \
     * 2   5
     * / \
     * 5   7
     * <p>
     * 输出: 5
     * 说明: 最小的值是 2 ，第二小的值是 5 。
     * 示例 2:
     * <p>
     * 输入:
     * 2
     * / \
     * 2   2
     * <p>
     * 输出: -1
     * 说明: 最小的值是 2, 但是不存在第二小的值。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        int r = findSecondMinimumValue(n1);
        System.out.println(r);

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;

        int r2 = findSecondMinimumValue(t1);
        System.out.println(r2);

    }

    public static int findSecondMinimumValue(TreeNode root) {
        //利用层序遍历二叉树
        int min = root.val;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int r = Integer.MAX_VALUE;
        //是否找到比最小值大的val
        boolean findBigger = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val > min) {
                findBigger = true;
                //比最小值大的数里面求最小值，即求第二小
                r = Math.min(r, poll.val);
            }
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        if (!findBigger) return -1;
        return r;
    }

}
