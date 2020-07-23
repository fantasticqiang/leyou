package com.lq.easy;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lq on 2020/5/14.
 */
public class T13deleteDuplicates {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        ListNode result = deleteDuplicates(listNode);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }

        //204 list反转
        //解法1
//        ListNode result = reverseList(listNode);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }
        //解法2
        reverseList2(listNode, 1);
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     * <p>
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while (result != null && result.next != null) {
            if (result.val == result.next.val) {
                result.next = result.next.next;
            } else {
                result = result.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp.next != null) { // 注意尾结点的处理
            if (temp.next.val != temp.val)
                temp = temp.next;
            else {
                ListNode cursor = temp.next; // 外循环条件保证cursor非null
                while (cursor.next != null && cursor.next.val == cursor.val) // cursor 经过循环成为相同元素的最后一个结点
                    cursor = cursor.next;
                temp.next = cursor.next;
            }
        }
        return head;
    }

    /**
     * T206
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head, int level) {
        if (head == null || head.next == null) return head;
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < level; i++) {
            msg.append("\t");
        }
        msg.append("下沉阶段：当前节点：" + head.val + ", 下一个节点：" +head.next.val);
        System.out.println(msg.toString());
        ListNode p = reverseList2(head.next, level + 1);
        StringBuilder msg2 = new StringBuilder();
        for (int i = 0; i < level; i++) {
            msg2.append("\t");
        }
        msg2.append("上浮阶段：当前节点(head.next)：" + head.next.val + ", 上一个节点(head)：" + head.val + ", head.next.next=head(表示当前节点.next=上一个节点),即" + head.next.val + "->" + head.val);
        System.out.println(msg2);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
