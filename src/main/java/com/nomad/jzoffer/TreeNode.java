package com.nomad.jzoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class HasSubtree {
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                flag = doHasSubTree(root1, root2);
            }
            if (!flag) {
                flag = hasSubtree(root1.left, root2);
            }
            if (!flag) {
                flag = hasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    public boolean doHasSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doHasSubTree(root1.left, root2.left) && doHasSubTree(root1.right, root2.right);
    }
}

class Mirror {
    public void mirror(TreeNode root) {
        if (root==null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }
}

class BFS {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return  result; //如果返回null，PAT编译器不通过
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode head = queue.poll();
            result.add(head.val);
            if (head.left!= null) {
                queue.add(head.left);
            }
            if (head.right!=null) {
                queue.add(head.right);
            }
        }

        return result;
    }
}

class PostOrder {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }
        int i = r;
        while (i > l && sequence[i - 1] > sequence[r]) { //从后向前遍历序列，跳过所有比root大的值，(若没有比root小的值，最后i指向仅剩的一个比root大的元素，否则i-1指向最后一个比root小的元素)
            i--;
        }
        for (int j = i - 1; j >= l; j--) {//从i开始逆向遍历，发现比root大的值就返回false
            if (sequence[j] > sequence[r]) {
                return false;
            }
        }
        return judge(sequence, l, i - 1) && judge(sequence, i, r - 1); //递归判断
    }
}

class FindPath {
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>(); //所有路径
    ArrayList<Integer> list = new ArrayList<>(); //一条路径

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if (root == null) {
            return listAll;
        }

        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null) { //到达叶子节点并且target减为0
            listAll.add(new ArrayList<>(list)); //把当前路径加入结果集
        }
        findPath(root.left, target);
        findPath(root.right, target);

        list.remove(list.size() - 1);//返回前从当前路径移除当前节电
        return listAll;
    }
}

