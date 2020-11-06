package com.nomad.xz.pdd;

import java.util.*;

public class Main_21 {
    public static void main(String[] args) {
        new Main_21().pack();
    }

    /**
     * n个集合并集，容斥原理
     */
    public void feacher() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] feachers = new int[m];
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            feachers[i] = sc.nextInt();
            int j = 1;
            while (j * feachers[i] <= n) {
                res.add(j * feachers[i]);
                j++;
            }
        }

        System.out.println(res.size());
    }

    /**
     * 负值0/1背包
     */
    public void pack() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] cv = new int[n][2];
        for (int i = 0; i < n; i++) {
            cv[i][0] = sc.nextInt();
            cv[i][1] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0 && j >= cv[i][0]; j--) {
               dp[j] = Math.max(dp[j], dp[j - cv[i][0]] + cv[i][1]);
            }
        }

        System.out.println(dp[m]);
    }

    /**
     * 矩阵交换一次0和1,最多的连续1个数
     */
    public void queueSoldror() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] nums = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
                if (nums[i][j] == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    /**
     * 米字型矩阵
     */
    public void printMitrix() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][n];
//        if (n % 2 == 0) {
        for (int i = 1; i < n / 2; i++) {
            for (int j = 0; j < i; j++) {
                res[i][j] = 3;
                res[j][i] = 2;
                res[j][n - 1 - i] = 1;
                res[n - 1 - i][j] = 4;
                res[n - 1 - j][i] = 5;
                res[n - 1 - i][n - 1 - j] = 7;
                res[n - 1 - j][n - 1 - i] = 6;
                res[i][n - 1 - j] = 8;
            }
        }
//        } else {
//
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}
class Main_pdd {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n4.left = n2; n4.right = n5;
        n2.left = n1; n2.right = n3;

        new Main_pdd().x2(n4);
        Node p = n4;
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.println(res.get(i));
        }
    }

    static LinkedList<Integer> res = new LinkedList<>();
    public Node x1(Node root){
        if (root == null) {
            return root;
        }
        Node lchild = x1(root.left);
        if (lchild != null) {
            res.add(lchild.val);
        }
        res.add(root.val);
        Node rchilde = x1(root.right);
        if (rchilde != null) {
            res.add(rchilde.val);
        }

        return null;
    }

    public Node x2(Node root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return root;
        }

        if (root.left != null) {
            x2(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            x2(root.right);
        }

        return null;
    }
}


class Main_pdd2 {
    public static void main(String[] args) {
        new Main_pdd2().x3();
    }

    /**
     * 多多的道路修建
     */
    public void x4(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        System.out.println(m + n - 1);
    }

    /**
     *
     * 多多的最大和
     */
    public void x3(){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int res = 0;
            int n = sc.nextInt(), k = sc.nextInt();
            Integer[] scores = new Integer[n + 1];
            for (int j = 0; j < n; j++) {
                scores[j + 1] = sc.nextInt();
            }
            Map<Integer, List<Integer>> id_id = new HashMap<>();
            for (int j = 0; j < k; j++) {
                int id = sc.nextInt();
                List<Integer> ids = id_id.computeIfAbsent(id, ArrayList::new);
                ids.add(sc.nextInt());
            }

            for (int j = 1; j <= n; j++) {
                int sum = 0;
                Set<Integer> queue = new HashSet<>();
                queue.add(j);
                sum += scores[j];
                List<Integer> ids = id_id.get(j);
                for (Integer id : ids) {
                    if (!queue.contains(id)) {
                        queue.add(j);

                    }
                }
            }
        }
    }

    /**
     * 多多鸡的历险记
     * 应该用BFS,借助Queue, 复杂度低点
     */
    class Axis implements Comparable<Axis>{
        int x;
        int y;

        public Axis() {
        }

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Axis o) {
            if (x == o.x) {
                return y - o.y;
            }
            return x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Axis axis = (Axis) o;
            return x == axis.x &&
                    y == axis.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    List<Axis> res = new ArrayList<>();
    int sum = Integer.MAX_VALUE;
    int[][] dire = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public void x2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] chars = new char[n][m];
        List<Axis> start = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < m; j++) {
                chars[i][j] = tmp.charAt(j);
                if (chars[i][j] == 'X') {
                    start.add(new Axis(i, j));
                }
            }
        }
        for (Axis axis : start) {
            for (int i = 0; i < dire.length; i++) {
                int xx = axis.x + dire[i][0];
                int yy = axis.y + dire[i][1];
                chars[axis.x][axis.y] = '1';
                x20(chars, xx, yy, 0, axis.x, axis.y);
                chars[axis.x][axis.y] = 'X';
            }
        }

        if (sum == Integer.MAX_VALUE) {
            System.out.println(0);
        }else {
            Collections.sort(res);
            System.out.println(sum + 1);
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i < res.size()) {
                    System.out.print(" ");
                } else
                    System.out.println();
            }
        }
    }

    private void x20(char[][] chars, int x, int y, int len, int o_x, int o_y) {
        if (x < 0 || x >= chars.length || y < 0 || y >= chars[0].length) {
            return;
        }
        if (chars[x][y] == '1' || chars[x][y] == 'X') {
            return;
        }
        if (chars[x][y] == 'T') {
            if (sum > len) {
                sum = len;
                res.clear();
                res.add(new Axis(o_x, o_y));
            } else if (sum == len) {
                if (!res.contains(new Axis(o_x, o_y))) {
                    res.add(new Axis(o_x, o_y));
                }
            }
            return;
        }

        chars[x][y] = '1';
        len++;
        for (int i = 0; i < dire.length; i++) {
            int xx = x + dire[i][0];
            int yy = y + dire[i][1];
            x20(chars, xx, yy, len, o_x, o_y);
        }
        chars[x][y] = '0';
    }

    /**
     * 多多的读数游戏
     */
    public void x1(){
        int[][][] pattern = new int[][][]{
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 1, 1, 0, 1, 1, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                },
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        };
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] nums = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    nums[j][k] = sc.nextInt();
                }
            }
            int num = equals(nums, pattern);
            System.out.println(num);
        }
    }

    private int equals(int[][] nums, int[][][] pattern) {
        int len = nums.length;
        int incr = len / 10;
        int i = 0;
        for (; i < 10; i++) {
            int j = 0;
            for (; j < 10; j++) {
                int k = 0;
                for (; k < 10; k++) {
                    int l = 0;
                    for (; l < incr; l++) {
                        if (pattern[i][j][k] != nums[j * incr + l][k * incr + l]) {
                            break;
                        }
                    }
                    if (l < incr) {
                        break;
                    }
                }
                if (k < 10) {
                    break;
                }
            }
            if (j == 10) {
                break;
            }
        }

        return i;
    }
}