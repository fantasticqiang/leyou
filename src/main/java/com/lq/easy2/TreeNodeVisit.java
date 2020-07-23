package com.lq.easy2;

import java.util.*;

/**
 * @author lq
 * @date 2020-06-11 09:42
 */
public class TreeNodeVisit {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;


        ArrayList<Integer> pre = new ArrayList<>();
        visit2(node1, pre);
        pre.stream().forEach(System.out::println);
        System.out.println("----------");
        ArrayList<Integer> mid = new ArrayList<>();
        visitMid(node1, mid);
        mid.stream().forEach(System.out::println);
        System.out.println("----------");
        //bfs(node1);

        //二叉树重建
        TreeNode result = new TreeNode(-1);
        rebuildTree(pre, mid, result);
        ArrayList<Integer> preResult = new ArrayList<>();
        visit2(result,preResult);
        preResult.stream().forEach(System.out::println);


    }

    public static void rebuildTree(List<Integer> pre, List<Integer> mid, TreeNode result) {
        ArrayList<Integer> midLeft = new ArrayList<>();
        ArrayList<Integer> midRight = new ArrayList<>();
        if(pre.size() >= 1) {
            Integer root = pre.get(0);
            result.val = root;
            boolean findRoot = false;
            for (int i = 0; i < mid.size(); i++) {
                if(findRoot == false && mid.get(i).intValue() != root.intValue()) {
                    midLeft.add(mid.get(i));
                }else if (mid.get(i).intValue() == root.intValue()) {
                    findRoot = true;
                }else if(findRoot == true) {
                    midRight.add(mid.get(i));
                }
            }
            //求前序left，前序right
            if(midLeft.size() > 0 ) {
                List<Integer> preLeft = pre.subList(1, midLeft.size() + 1);
                List<Integer> preRight = pre.subList(midLeft.size() + 1, pre.size());
                TreeNode leftNode = new TreeNode(-1);
                result.left = leftNode;
                rebuildTree(preLeft, midLeft, leftNode);
                TreeNode nodeRight = new TreeNode(-1);
                result.right = nodeRight;
                rebuildTree(preRight, midRight, nodeRight);
            }
        }

    }

    public static void visit(TreeNode treeNode, List<Integer> result) {
        if(treeNode != null) {
            result.add(treeNode.val);
            visit(treeNode.left, result);
            visit(treeNode.right, result);
        }
    }

    public static void visitMid(TreeNode treeNode, List<Integer> result) {
        if(treeNode != null) {
            visitMid(treeNode.left, result);
            result.add(treeNode.val);
            visitMid(treeNode.right, result);
        }
    }

    public static void visit2(TreeNode treeNode, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        if(treeNode == null) {
            return;
        }
        stack.push(treeNode);
        while ( !stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.right != null) {
                stack.push(pop.right);
            }
            if(pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void bfs(TreeNode treeNode) {
        if (treeNode == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
