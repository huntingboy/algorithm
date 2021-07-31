package com.nomad.xz.ne;

import java.util.*;

public class Main_21_2 {
    public static void main(String[] args) {
        new Main_21_2().x4();
    }

    /**
     * 约会匹配
     * 八皇后改进
     */
    public void x4(){
        Scanner sc = new Scanner(System.in);
        String[] bid = sc.nextLine().split(" ");
        int m = bid.length;
        String[] gid = sc.nextLine().split(" ");
        int n = gid.length;
        boolean[][] nums = new boolean[m][n];
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            //nums[sc.nextInt()][sc.nextInt()] = true;
            sc.nextLine();
        }

        for (int i = 0; i < n; i++) {

        }

        System.out.println((m + n) / 2);
    }

    /**
     * 送快递
     */
    int res = 0;
    public void x3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 1; i < n; i++) {
            nums[i] = sc.nextInt();
            ArrayList<Integer> list = edge.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            edge.put(nums[i], list);
        }

        ArrayList<Integer> next = edge.get(0);
        for (Integer i : next) {
            x30(edge, i, k, 0);
        }
        System.out.println(res + 1);
    }

    private void x30(Map<Integer, ArrayList<Integer>> edge, int i, int k, int len) {
        if (k == 0 || i == -1) {
            res = Math.max(res, len);
            return;
        }

        len++;
        k--;
        ArrayList<Integer> next = edge.get(i);
        if (next == null) {
            x30(edge, -1, k, len);
        } else {
            for (Integer ii : next) {
                x30(edge, ii, k, len);
            }
        }
    }

    /**
     * 成双成对
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        int[][][] dp_a2z = new int[len][len][6];
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                char ch = str.charAt(j);
                switch (ch) {
                    case 'a':
                        dp_a2z[i][j][0] = (i == j) ? 1 : dp_a2z[i][j - 1][0] + 1;
                        for (int k = 0; k < 6; k++) {
                            if(i != j && k != 0) dp_a2z[i][j][k] = dp_a2z[i][j - 1][k];
                        }
                        break;
                    case 'b':
                        dp_a2z[i][j][1] = (i == j) ? 1 : dp_a2z[i][j - 1][1] + 1;
                        for (int k = 0; k < 6; k++) {
                            if(i != j && k != 1) dp_a2z[i][j][k] = dp_a2z[i][j - 1][k];
                        }
                        break;
                    case 'c':
                        dp_a2z[i][j][2] = (i == j) ? 1 : dp_a2z[i][j - 1][2] + 1;
                        for (int k = 0; k < 6; k++) {
                            if(i != j && k != 2) dp_a2z[i][j][k] = dp_a2z[i][j - 1][k];
                        }
                        break;
                    case 'x':
                        dp_a2z[i][j][3] = (i == j) ? 1 : dp_a2z[i][j - 1][3] + 1;
                        for (int k = 0; k < 6; k++) {
                            if(i != j && k != 3) dp_a2z[i][j][k] = dp_a2z[i][j - 1][k];
                        }
                        break;
                    case 'y':
                        dp_a2z[i][j][4] = (i == j) ? 1 : dp_a2z[i][j - 1][4] + 1;
                        for (int k = 0; k < 6; k++) {
                            if(i != j && k != 4) dp_a2z[i][j][k] = dp_a2z[i][j - 1][k];
                        }
                        break;
                    case 'z':
                        dp_a2z[i][j][5] = (i == j) ? 1 : dp_a2z[i][j - 1][5] + 1;
                        for (int k = 0; k < 6; k++) {
                            if(i != j && k != 5) dp_a2z[i][j][k] = dp_a2z[i][j - 1][k];
                        }
                        break;
                    default:
                        for (int k = 0; k < 6; k++) {
                            if(i != j) dp_a2z[i][j][k] = dp_a2z[i][j - 1][k];
                        }
                        continue;
                }

                int k = 0;
                for (; k < 6; k++) {
                    if (dp_a2z[i][j][k] % 2 == 1) {
                        break;
                    }
                }
                if (k == 6) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        System.out.println(res);
    }

    /**
     * 树上摘樱桃
     */
    class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public void x1(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node p = null;
            if (nodes.containsKey(val)) {
                p = nodes.get(val);
            }else {
                p = new Node(val);
                nodes.put(val, p);
            }
            String pos = sc.next();
            int val1 = sc.nextInt();
            Node c = null;
            if (nodes.containsKey(val1)) {
                c = nodes.get(val1);
            }else {
                c = new Node(val1);
                nodes.put(val1, c);
            }
            if ("left".equals(pos)) {
                p.left = c;
            } else {
                p.right = c;
            }
        }

        int res = 0;
        for (Node node : nodes.values()) {
            if (node.left != null && node.right != null) {
                Node l = node.left;
                Node r = node.right;
                if (l.left == null && l.right == null && r.left == null && r.right == null) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
