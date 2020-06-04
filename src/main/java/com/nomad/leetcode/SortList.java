package com.nomad.leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SortList {
    public ListNode sortList(ListNode head) { //sort-list
        if (head == null || head.next == null) { //0或1个节点
            return head;
        }
        ListNode middle = findMiddle(head);
        //断开链
        ListNode midNext = middle.next;
        middle.next = null;
        return sortListMerge(sortList(head), sortList(midNext));
    }

    private ListNode sortListMerge(ListNode l, ListNode r) {
        if (l == null || r == null) {
            if (l == null) {
                return r;
            }else
                return l;
        }
        ListNode head, p;
        if (l.val < r.val) {
            head = l;
            l = l.next;
        } else {
            head = r;
            r = r.next;
        }
        p = head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        if (l == null) {//左链走完
            p.next = r;
        } else { //右链走完
            p.next = l;
        }
        return head;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {  //前者对于奇数个节点  后者对于偶数个节点
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode insertionSortList(ListNode head) {//insertion-sort-list
        if (head == null || head.next == null) { //0或1个节点
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE); //头部哨兵节点
        ListNode cur = head, pre = newHead;  //cur指向源链表中要插入的节点   pre指向目标链表中要插入节点的前面一个节点
        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) { //在目标链表中找到要插入的位置 pre后面插入
                pre = pre.next;
            }
            if (pre.next == null) { //在目标链表的最后插入cur节点
                pre.next = cur;
                cur = cur.next;
                pre.next.next = null;
            } else {
                ListNode tmp = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = tmp;
            }
            pre = newHead;
        }
        return newHead.next;
    }
}
