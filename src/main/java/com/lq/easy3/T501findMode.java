package com.lq.easy3;

import com.lq.TreeNode;

import java.util.*;

/**
 * @author lq
 * @date 2020-06-27 21:42
 */
public class T501findMode {

    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     *
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.right = node2;
        node2.left = node3;
        int[] r = findMode(node1);
        Arrays.stream(r).forEach(x -> System.out.println(x));

        int[] r2 = findMode2(node1);
        Arrays.stream(r2).forEach(x -> System.out.println(x));

        int[] r3 = findMode3(node1);
        Arrays.stream(r3).forEach(x -> System.out.println(x));
    }

    public static int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return new int[]{};
        }
        stack.add(root);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
            map.put(pop.val, map.getOrDefault(pop.val, 0) + 1);
        }
        Collection<Integer> values = map.values();
        int max = 0;
        for (Integer v : values) {
            max = Math.max(max, v);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == max) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] findMode2(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }
        ArrayList<Integer> result = new ArrayList<>();
        int max = 0;
        int cur = 1;
        //中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (pre != null) {
                if (current.val == pre.val) {
                    cur++;
                } else {
                    cur = 1;
                }

            }
            if (cur == max) {
                result.add(current.val);
            }
            if (cur > max) {
                result.clear();
                result.add(current.val);
                max = cur;
            }
            pre = current;
            current = current.right;
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    static int maxTimes = 0;
    static int thisTimes = 0;
    static List<Integer> res = new LinkedList<Integer>();
    static TreeNode pre = null;
    public static int[] findMode3(TreeNode root) {
        inOrder(root);
        int length = res.size();
        int[] rr = new int[length];
        for(int i = 0; i < length; i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        if(pre != null && pre.val == root.val) {
            thisTimes++;
        } else {
            thisTimes = 1;
        }
        if(thisTimes == maxTimes) {
            res.add(root.val);
        } else if(thisTimes > maxTimes) {
            maxTimes = thisTimes;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }

}
