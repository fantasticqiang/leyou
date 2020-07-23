package com.lq.easy;

/**
 * Created by lq on 2020/4/19.
 */
public class T2MergeTwoList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next =listNode3;
        listNode3.next = listNode4;

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2);
        ListNode listNode2_4 = new ListNode(4);
        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_4;

        ListNode listNode = mergeTwoList(listNode1, listNode2_1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static class ListNode {
        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTowList(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);

        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if(l1.val <= l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }



}
