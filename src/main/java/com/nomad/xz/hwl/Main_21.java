package com.nomad.xz.hwl;

import java.util.Stack;

/**
 * 好未来
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

public class Main_21 {
    public static void main(String[] args) {
        new Main_21().notReCuPreOrder(null);
    }

    /**
     * 逆序
     */
    class Node{
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public Node reverseList (Node head) {
        // write code here
        if (head.getNext() == null) {
            return head;
        }
        Node pre = head.getNext(), p = head.getNext().getNext();
        pre.setNext(null);
        while (p != null) {
            Node tmp = p.getNext();
            p.setNext(pre);
            pre = p;
            p = tmp;
        }

        Node res = new Node();
        res.setNext(pre);
        return res;
    }

    /**
     * 二叉树的非递归前序遍历
     * @param root TreeNode类 根节点
     * @return string字符串
     */
    public String notReCuPreOrder (TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val + ",");
            if (node.right != null && node.right.val != '#') {
                stack.add(node.right);
            }
            if (node.left != null && node.left.val != '#') {
                stack.add(node.left);
            }
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
