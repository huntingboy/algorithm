package com.nomad.jzoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int[] array) {
        assert (array.length > 0);
        this.val = array[0];
        for (int i = 1; i < array.length; i++) {
            createBST(this, array[i]);
        }
    }

    private TreeNode createBST(TreeNode root, int i) { //不像c++有&类型，所以只能返回TreeNode而不是boolean
        if (root == null) {
            return new TreeNode(i);
        }
        if (root.val == i) { //BST不允许同样的值
            throw new Error("BST不允许同样的值");
        }else if (i < root.val) {
            root.left = createBST(root.left, i); //插入左子树
        } else {
            root.right = createBST(root.right, i); //插入右子树
        }
        return root;
    }

    public void printPreOrder(){ //先序遍历打印输出
        printPreOrder(this);
    }

    private void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printInOrder(){ //中序遍历打印输出
        printInOrder(this);
    }

    private void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }

    public void printPostOrder() { // 后序遍历打印输出
        printPostOrder(this);
    }

    private void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }

    public int treeDepth(){
        return treeDepth(this);
    }

    private int treeDepth(TreeNode root) { //树的深度  即树的高度!=节点的深度   深度:从当前节点到root   高度:从当前节点到leaf
        if (root == null) {
            return 0;
        }

        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    public boolean isBalanced_Solution(){
        return isBalanced_Solution(this);
    }

    private boolean isBalanced_Solution(TreeNode root) { //平衡二叉树判断  最大、最小高度差<=1  在求高度时带剪枝，减少了重复的树的遍历
        return (getHeight(root) != -1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getHeight(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;  //如果子树不是AVL树就直接返回-1,退出
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

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {//根到叶子节点的所有路径
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

class InOrder{
    TreeNode pre = null;  //因为没有c++的&类型，所以能作为函数参数进行修改，只能作为类的字段进行修改
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
//        TreeNode pre = null; //指向pRootOfTree的前一个节点
        convertAll(pRootOfTree);

        TreeNode result = pRootOfTree;
        while (result.left != null) {
            result = result.left;
        }

        return result;
    }

    private void convertAll(TreeNode cur) {
        if (cur == null) {
            return;
        }
        convertAll(cur.left);  //处理左子树

        //引用更新
        cur.left = pre;
        if (pre != null) {
            pre.right = cur;
        }
        pre = cur;

        convertAll(cur.right); //处理右子树
    }
}

