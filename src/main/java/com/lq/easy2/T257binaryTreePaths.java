package com.lq.easy2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lq
 * @date 2020-06-01 20:11
 */
public class T257binaryTreePaths {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

//        List<String> strings = binaryTreePaths(node1);
//        for(String s : strings) {
//            System.out.println(s);
//        }

        List<String> strings = binaryTreePaths2(node1);
        for (String s : strings) {
            System.out.println(s);
        }

    }

    public static List<String> binaryTreePaths(TreeNode node) {
        ArrayList<String> result = new ArrayList<>();
        findPath(node, result, "" );
        return result;
    }

    private static void findPath(TreeNode node, List<String> result, String tmp) {
        if(node != null) {
            if(tmp.length() != 0) {
                tmp += ("->");
            }
            tmp += (node.val);
            if(node.left != null) {
                findPath(node.left, result, tmp);
            }
            if(node.right != null) {
                findPath(node.right, result, tmp);
            }
            if(node.left == null && node.right == null) {
                result.add(tmp);
            }

        }
    }

    public static List<String> binaryTreePaths2(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null)
            return paths;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }
}
