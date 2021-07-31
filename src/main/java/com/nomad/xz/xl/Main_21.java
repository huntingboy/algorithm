package com.nomad.xz.xl;

import java.util.*;

/**
 * 新浪
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x2();
    }

    /**
     * 重复字符串筛查
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();
        Arrays.sort(chars);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }

    /**
     * 二叉树转换
     */
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }
    private TreeNode newRoot;
    private boolean first = true;
    public void x1(){
        Scanner sc = new Scanner(System.in);
        Vector<TreeNode> nums = new Vector<>();
        while (sc.hasNext()) {
            int i = sc.nextInt();
            nums.add(new TreeNode(i));
        }

        for (int i = 1; i < nums.size(); i++) {
            TreeNode tmp = nums.get(i);
            int p = i / 2;
            if (i % 2 == 0) {
                nums.get(p).right = tmp;
            } else {
                nums.get(p).left = tmp;
            }
        }

        updown(nums.get(0));
        Queue<TreeNode> res = new ArrayDeque<>();
        res.add(newRoot);
        int i = 0;
        while (!res.isEmpty()) {
            TreeNode cur = res.poll();
            System.out.print(cur.val);
            i++;
            if (i == nums.size() - 1) {
                System.out.println();
            }else {
                System.out.print(",");
            }
            if (cur.left != null) {
                res.offer(cur.left);
            }
            if (cur.right != null) {
                res.offer(cur.right);
            }
        }
    }

    private void updown(TreeNode root) { //后序
        if (root.left == null) {
            if (first) {
                first = false;
                newRoot = root;
            }
            return;
        }

        updown(root.left);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        left.left = right;
        left.right = left;
    }
}
