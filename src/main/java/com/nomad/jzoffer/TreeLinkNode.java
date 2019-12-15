package com.nomad.jzoffer;

public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;  //指向父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}

class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode)//二叉树的下一个结点
    {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) { //右子树不为空，则向下找到最左子节点
            TreeLinkNode rChild = pNode.right;
            while (rChild.left != null) {
                rChild = rChild.left;
            }
            return rChild;
        }
        while (pNode.next != null) {
            TreeLinkNode parent = pNode.next;
            if (parent.left == pNode) { //pnode是parent的左孩子
                return parent;
            } else {
                pNode = pNode.next;
            }
        }
        return null;
    }
}

