package com.lq.easy3;

import java.util.List;

/**
 * @author lq
 * @date 2020-07-07 20:37
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
