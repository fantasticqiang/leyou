package com.lq.easy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lq
 * @date 2020-05-24 08:14
 */
public class T28rob {

    public static void main(String[] args) {
//        int[] nums = {2, 1, 1, 2};
//        int rob = rob(nums);
//        System.out.println(rob);
//        int[] nums2 = {1, 2, 3, 1};
//        int rob1 = rob(nums2);
//        System.out.println(rob1);
//        int i = rob2(nums);
//        System.out.println(i);

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.right = treeNode5;
        int i = rob3(treeNode1);
        System.out.println(i);

//        int i4 = rob4(treeNode1);
//        System.out.println(i4);
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * [2,1,1,2]
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;

    }

    public static int rob2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        for (int i = 0; i < len; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[len + 1];
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     * <p>
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     *      3
     * / \
     * 4   5
     * / \   \
     * 1   3   1
     * <p>
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     * @return
     */
    public static int rob3(TreeNode root) {
        //思路层序遍历，但是不能和父相连
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return robInternal(root, map);
    }

    public static int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money = root.val;

        if (root.left != null) {
            money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
        }
        if (root.right != null) {
            money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
        }
        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        memo.put(root, result);
        return result;
    }

    public static int rob4(TreeNode root) {
        int[] dp = dp(root);
        return Math.max(dp[0], dp[1]);
    }

    public static int[] dp(TreeNode root) {
        if(root == null) {
            return new int[2];
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //抢
        int rob = root.val + left[0] + right[0];
        //不抢
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {not_rob, rob};
    }
}
