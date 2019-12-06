package com.nomad.jzoffer;

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class RandomListNodeUtil {
    public RandomListNode clone(RandomListNode pHead) //链表完全复制
    {
        if (pHead == null) {
            return null;
        }
        RandomListNode pCurr = pHead;
        while (pCurr != null) { //A->B->C ===> A->A'->B->B'->C->C'
            RandomListNode node = new RandomListNode(pCurr.label);
            node.next = pCurr.next;
            pCurr.next = node;
            pCurr = node.next;
        }

        pCurr = pHead;
        while (pCurr != null) { //把复制的结点的random指针指向被复制结点的random指针的下一个结点
            if (pCurr.random != null) {
                pCurr.next.random = pCurr.random.next;
            }
            pCurr = pCurr.next.next;
        }

        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCurr = pHead;
        while (pCurr != null) { //拆分链表
            pCurr.next = pCurr.next.next;
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            pCurr = pCurr.next;
        }
        return head;
    }
}
