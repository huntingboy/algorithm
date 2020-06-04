package com.nomad.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Traversal {

    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> postorderTraversal(TreeNode root) {//binary-tree-postorder-traversal  递归解法
        if (root == null) {
            return res;
        }
        ArrayList<Integer> tmp = postorderTraversal(root.left); //左支
        //res.addAll(tmp);
        if (tmp != null) {
            for (int i = 0; i < tmp.size(); i++) {
                res.add(tmp.get(i));
            }
        }
        tmp = postorderTraversal(root.right); //右支
        //res.addAll(tmp);
        if (tmp != null) {
            for (int i = 0; i < tmp.size(); i++) {
                res.add(tmp.get(i));
            }
        }
        res.add(root.val); //根
        return res;
    }

    public ArrayList<Integer> postorderTraversal1(TreeNode root) {//非递归解法 借助栈
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode pre = null; //指向刚访问的节点
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))) { //叶子节点或者孩子已经被访问过的节点
                res.add(cur.val);
                nodes.pop();
                pre = cur;
            } else {
                if (cur.right != null) { //先把右孩子加到栈里面  因为取的时候从左孩子先取
                    nodes.add(cur.right);
                }
                if (cur.left != null) {
                    nodes.add(cur.left);
                }
            }
        }

        return res;
    }


    public ArrayList<Integer> preorderTraversal(TreeNode root) { //binary-tree-preorder-traversal  递归解法
        if (root == null) {
            return res;
        }
        res.add(root.val); //根
        ArrayList l = preorderTraversal(root.left); //左孩子
        ArrayList r = preorderTraversal(root.right); //右孩子
        res.addAll(l);
        res.addAll(r);
        return res;
    }

    public ArrayList<Integer> preorderTraversal1(TreeNode root) { //栈解法  注意孩子放入栈的次序，先右孩子，后左孩子
        if (root == null) {
            return res;
        }
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pop();
            if (cur.right != null) {
                nodes.add(cur.right);
            }
            if (cur.left != null) {
                nodes.add(cur.left);
            }
            res.add(cur.val);
        }

        return res;
    }
}
