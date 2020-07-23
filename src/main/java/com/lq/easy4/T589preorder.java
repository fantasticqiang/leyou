package com.lq.easy4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lq
 * @date 2020-07-12 13:54
 */
public class T589preorder {

    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * <p>
     * 例如，给定一个 3叉树 :
     * <p>
     * 返回其前序遍历: [1,3,5,6,2,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        ArrayList<Node> c1 = new ArrayList<>();
        c1.add(n2);
        c1.add(n3);
        c1.add(n4);
        n1.children = c1;
        ArrayList<Node> c2 = new ArrayList<>();
        c2.add(n5);
        c2.add(n6);
        n2.children = c2;
        preorder(n1);
        result.stream().forEach(System.out::println);

        System.out.println("--------");

        postorder(n1);
        result2.stream().forEach(System.out::println);

        System.out.println("--------");

        List<Integer> result3 = postorder2(n1);
        result3.stream().forEach(System.out::println);

    }

    public static List<Integer> result = new ArrayList<>();
    public static List<Integer> result2 = new ArrayList<>();

    public static List<Integer> preorder(Node root) {
        if (root != null) {
            result.add(root.val);
            if (root.children != null) {
                for (Node n : root.children) {
                    preorder(n);
                }
            }
        }
        return result;
    }


    public static List<Integer> postorder(Node root) {
        if (root != null) {
            if (root.children != null) {
                for (Node n : root.children) {
                    postorder(n);
                }
            }
            result2.add(root.val);
        }
        return result2;
    }


    public static List<Integer> postorder2(Node root) {

        LinkedList<Integer> r = new LinkedList<>();
        //迭代法
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) {
            return r;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            r.addFirst(node.val);
            if (node.children == null) continue;
            for (Node n : node.children) {
                if (n != null) stack.add(n);
            }
        }
        return r;
    }

}
