package com.lq.easy4;

import java.util.List;

/**
 * @author lq
 * @date 2020-07-12 13:55
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
