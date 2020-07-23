package com.lq.easy3;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lq
 * @date 2020-07-07 20:38
 */
public class T559maxDepth {

    /**
     * 给定一个 N 叉树，找到其最大深度。
     *
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     *
     * 例如，给定一个 3叉树 : 
     *
     * 我们应返回其最大深度，3。

     * @param args
     */
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        ArrayList<Node> c1 = new ArrayList<>();
        c1.add(n2);
        c1.add(n3);
        c1.add(n4);
        n1.children = c1;
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        ArrayList<Node> c2 = new ArrayList<>();
        c2.add(n5);
        c2.add(n6);
        n2.children = c2;

        int r = maxDepth(n1);
        System.out.println(r);

        int r2 = maxDepth2(n1);
        System.out.println(r2);
    }

    public static int maxDepth(Node node) {
        if (node == null) return 0;
        //层序遍历
        Stack<Pair<Node, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(node, 1));
        int height = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> pop = stack.pop();
            Node tmpNode = pop.getKey();
            int h = pop.getValue();
            height = Math.max(h, height);
            if (tmpNode.children != null && tmpNode.children.size() >= 1) {
                for (Node c : tmpNode.children) {
                    stack.push(new Pair<>(c, h + 1));
                }
            }
        }
        return height;
    }

    // 递归
    public static int maxDepth2(Node node) {
        if(node == null) {
            return 0;
        }
        int max = 0;
        if (node.children == null || node.children.size() == 0) return max + 1;
        for (Node n : node.children) {
            int t = maxDepth2(n);
            max = Math.max(t, max);
        }
        return max + 1;
    }

}
