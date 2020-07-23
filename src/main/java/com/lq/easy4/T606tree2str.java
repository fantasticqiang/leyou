package com.lq.easy4;

import java.util.*;

/**
 * @author lq
 * @date 2020-07-13 15:35
 */
public class T606tree2str {

    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * <p>
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 二叉树: [1,2,3,4]
     * 1
     * /   \
     * 2     3
     * /
     * 4
     * <p>
     * 输出: "1(2(4))(3)"
     * <p>
     * 解释: 原本将是“1(2(4)())(3())”，
     * 在你省略所有不必要的空括号对之后，
     * 它将是“1(2(4))(3)”。
     * 示例 2:
     * <p>
     * 输入: 二叉树: [1,2,3,null,4]
     * 1
     * /   \
     * 2     3
     * \
     * 4
     * <p>
     * 输出: "1(2()(4))(3)"
     * <p>
     * 解释: 和第一个示例相似，
     * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        String r = tree2str(n1);
        System.out.println(r);

        TreeNode n2_1 = new TreeNode(1);
        TreeNode n2_2 = new TreeNode(2);
        TreeNode n2_3 = new TreeNode(3);
        TreeNode n2_4 = new TreeNode(4);
        n2_1.left = n2_2;
        n2_1.right = n2_3;
        n2_2.right = n2_4;

        String r2 = tree2str(n2_1);
        System.out.println(r2);

        TreeNode n31 = new TreeNode(1);
        TreeNode n32 = new TreeNode(2);
        TreeNode n33 = new TreeNode(3);
        n31.left = n32;
        n31.right = n33;

        String r3 = tree2str(n31);
        System.out.println(r3);

        String r4 = tree2str2(n31);
        System.out.println(r4);

    }

    public static String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }

    public static String tree2str2(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet< >();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }

}
