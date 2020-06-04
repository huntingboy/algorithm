package com.nomad.leetcode;

public class MinDepth {

    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int run(TreeNode root) { //minimum-depth-of-binary-tree
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) { //左右子树均不为空
            return Math.min(run(root.left), run(root.right)) + 1;
        }
        if (root.left == null) { //左单支
            return run(root.right) + 1;
        }
        return run(root.left) + 1; //右单支
    }
}
