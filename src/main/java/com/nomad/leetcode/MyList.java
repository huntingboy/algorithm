package com.nomad.leetcode;

import java.util.Scanner;

public class MyList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = null, p = null;
        for (int i = 0; i < n; i++) {
            ListNode tmp = new ListNode(scanner.nextInt());
            if (head == null) {
                head = tmp;
                p = head;
            } else {
                p.next = tmp;
                p = tmp;
            }
        }
        p.next = null;
        System.out.println("new MyList().swapPairs(head) = " + new MyList().swapPairs(head));
    }

    //删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }

        ListNode pre = head, p = head;
        while (n-- > 0) { //pre, p步长为n
            p = p.next;
        }
        if (p == null) { //删除第一个节点
            head = head.next;
            return head;
        }
        while (p.next != null) {
            pre = pre.next;
            p = p.next;
        }
        pre.next = pre.next.next;

        return head;
    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null, p = null, tmp = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (head == null) {
                head = tmp;
            } else {
                p.next = tmp;
            }
            p = tmp;
        }
        while (l1 != null) {
            tmp = new ListNode(l1.val);
            p.next = tmp;
            p = tmp;
            l1 = l1.next;
        }
        while (l2 != null) {
            tmp = new ListNode(l2.val);
            p.next = tmp;
            p = tmp;
            l2 = l2.next;
        }
        p.next = null;

        return head;
    }

    //合并K个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }

        return res;
    }

    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, pre = null;
        head = head.next;
        while (p != null && p.next != null) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = p;
            p = p.next;
            if (pre != null) {
                pre.next = tmp;
            }
            pre = tmp.next;
        }

        return head;
    }

    //K 个一组翻转链表 递归(衔接各个组)+迭代(反转一个组)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (nextHead == null) { //不足k个不反转,直接返回head
                return head;
            }
            nextHead = nextHead.next;
        }
        ListNode post = reverseKGroup(nextHead, k); //深度优先,返回链表后面已经处理的组
        ListNode pre = null;
        for (int i = 0; i < k; i++) {  //反转当前组并衔接post组
            pre = head.next;
            head.next = post;
            post = head;
            head = pre;
        }

        return post;
    }

    //原地反转链表 递归法
    public ListNode reverseRecur(ListNode head) {
        if (head.next == null) { //递归出口
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        ListNode res = reverseRecur(next);
        next.next = head;
        return res;
    }

    //原地反转链表 顺序反转
    public ListNode reverseSeq(ListNode head) {
        ListNode pre = null, p = null;
        while (head != null) {
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }

    //旋转链表 双指针 固定步长k
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode pre = head, p = head;
        for (int i = 0; i < k; i++) {
            p = (p.next == null) ? head : p.next;
        }
        while (p.next != null) {
            pre = pre.next;
            p = p.next;
        }
        p.next = head;
        head = pre.next;
        pre.next = null;

        return head;
    }
}
