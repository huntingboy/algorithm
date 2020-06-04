package com.nomad.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode add(int x){
        ListNode p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(x);
        return this;
    }
}
