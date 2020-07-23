package com.lq.easy;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lq on 2020/5/15.
 */
public class T16isSymmetric {

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(3);
//        TreeNode treeNode5 = new TreeNode(3);
//        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(4);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode4.left = treeNode6;
//        treeNode4.right = treeNode7;
//        boolean result = isSymmetric(treeNode1);
//        System.out.println(result);

//        int length = maxDepth3(treeNode1);
//        System.out.println(length);

//        List<List<Integer>> result = levelOrderBottom(treeNode1);
//        for (List<Integer> tmp : result) {
//            String join = tmp.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(","));
//            System.out.println(join);
//        }

//        int[] nums = {-10,-3,0,5,9};
//        TreeNode node = sortArrayToBST(nums);
//        List<List<Integer>> lists = levelOrderBottom(node);
//        for (List<Integer> tmp : lists) {
//            String join = tmp.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(","));
//            System.out.println(join);
//        }

//        //是否是平衡树
//        boolean balanced = isBalanced(treeNode1);
//        System.out.println(balanced);

//        //树的最小深度
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        treeNode1.left = treeNode2;
//        int minDepth = minDepth(treeNode1);
//        System.out.println(minDepth);

        //树从根节点到叶子节点是否存在和为sum
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
//        node2.left = node3;
//        node2.right = node4;
        boolean result = hasPathSum(node1, 1);
        System.out.println(result);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    /**
     * 求二叉树的最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root, int high) {
        if(root == null) {
            return high;
        }
        int leftHigh = maxDepth(root.left, high + 1);
        int rightHigh = maxDepth(root.right, high + 1);
        if(leftHigh > rightHigh ){
            return leftHigh;
        }
        return rightHigh;
    }

    public static int maxDepth3(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }

    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

     例如：
     给定二叉树 [3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回其自底向上的层次遍历为：

     [
     [15,7],
     [9,20],
     [3]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getOneLevel(Arrays.asList(root), result);
        Collections.reverse(result);
        return result;
    }

    private static void getOneLevel(List<TreeNode> nodes, List<List<Integer>> result) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<TreeNode> nextNodes = new ArrayList<>();
        if(nodes != null && nodes.size() >= 1) {
            for(TreeNode node : nodes) {
                tmp.add(node.val);
                if(node.left != null) {
                    nextNodes.add(node.left);
                }
                if(node.right != null) {
                    nextNodes.add(node.right);
                }
            }
        }
        result.add(tmp);
        if(nextNodes.size() >= 1) {
            getOneLevel(nextNodes, result);
        }
    }


    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

     本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

     示例:

     给定有序数组: [-10,-3,0,5,9],

     一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

     0
     / \
     -3   9
     /   /
     -10  5

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static TreeNode sortArrayToBST(int[] nums) {
        return getMid(nums, 0, nums.length - 1);
    }

    private static TreeNode getMid(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getMid(nums, l, mid - 1);
        node.right = getMid(nums, mid + 1, r);
        return node;
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。

     本题中，一棵高度平衡二叉树定义为：

     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

     示例 1:

     给定二叉树 [3,9,20,null,null,15,7]

      3
     / \
     9  20
     /  \
     15   7
     返回 true 。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/balanced-binary-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        //后序遍历
        return depth(root) !=  -1;
    }

    private static int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int depthLeft = depth(node.left);
        if(depthLeft == -1) {
            return -1;
        }
        int depthRight = depth(node.right);
        if(depthRight == -1) {
            return -1;
        }
        //比较高度
        int height = Math.abs(depthLeft - depthRight);
        return height < 2 ? Math.max(depthLeft, depthRight) + 1 : -1;
    }

    /**
     * 给定一个二叉树，找出其最小深度。

     最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

     说明: 叶子节点是指没有子节点的节点。

     示例:

     给定二叉树 [3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回它的最小深度  2.

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        //treeNode为null高度为0
        if(root == null) {
            return 0;
        } else {
            //左子树的最小高度
            int minDepthLeft = minDepth(root.left);
            //右子树的最小高度
            int minDepthRight = minDepth(root.right);
            //左右子树高度都不为0，返回树的高度 Math.min(left, right) + 1
            if(minDepthLeft != 0 && minDepthRight != 0) {
                return Math.min(minDepthLeft, minDepthRight) + 1;
            }
            //左右子树有一个高度为0，或者都为0，返回树的高度 Math.max(left, right) + 1
            return Math.max(minDepthLeft, minDepthRight) + 1;
        }
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

     说明: 叶子节点是指没有子节点的节点。

     示例: 
     给定如下二叉树，以及目标和 sum = 22，

        5
       / \
      4   8
      /  / \
     11  13 4
     /\      \
     7 2      1
     返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/path-sum
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return pathSum(root, 0, sum);
    }

    private static boolean pathSum(TreeNode treeNode, int preSum, int sum) {
        if(treeNode.left == null && treeNode.right == null) {
            preSum += treeNode.val;
            return preSum == sum;
        } else {
            preSum += treeNode.val;
            if(treeNode.left != null) {
                boolean leftHas = pathSum(treeNode.left, preSum, sum);
                if(leftHas ) {
                    return leftHas;
                }
            }
            if(treeNode.right != null) {
                boolean rightHas = pathSum(treeNode.right, preSum, sum);
                if(rightHas ) {
                    return rightHas;
                }
            }

        }
        return false;
    }





}
