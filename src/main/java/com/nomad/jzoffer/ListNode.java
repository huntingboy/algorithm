package com.nomad.jzoffer;


public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode result = head;
        while ((result = result.next) != null) {
            length++;

        }
        if(k > length) return null;
        k = length - k;
        result = head;
        while (k-- > 0) {
            result = result.next;
        }
        return result;
    }

    public ListNode findKthToTail1(ListNode head, int k) {
        ListNode p,q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            p = p.next;
            if (i >= k) {
                q = q.next;
            }
        }
        return i < k ? null : q;
    }
}

class ReverseList{
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p,q,r;
        r = head;
        q = r.next;
        p = q.next;
        while (p != null) {
            q.next = r;
            r = q;
            q = p;
            p = p.next;
        }
        q.next = r;
        head.next = null;
        return q;
    }
}

class Merge {
    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode list = null;
        ListNode tmp = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (list == null) {
                    list = list1;
                    tmp = list1;
                } else {
                    tmp.next = list1;
                    tmp = list1;
                }
                list1 = list1.next;
            } else {
                if (list == null) {
                    list = list2;
                    tmp = list2;
                } else {
                    tmp.next = list2;
                    tmp = list2;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            tmp.next = list2;
        } else {
            tmp.next = list1;
        }
        return list;
    }

    public ListNode merge1(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = merge1(list1, list2.next);
            return list2;
        }
    }
}

class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) { //两个链表的第一个公共结点  让长的链表先走长度差步
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        int len1 = 0, len2 = 0;
        while (p1 != null) { //链表长度计算
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        p1 = pHead1;
        p2 = pHead2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
