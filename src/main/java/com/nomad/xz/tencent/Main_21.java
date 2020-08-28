package com.nomad.xz.tencent;

import java.util.Scanner;

public class Main_21 {

    public static void main(String[] args) {
        new Main_21().sum();
    }

    /**
     * 最长回文串
     * dp[i][j]:[i,j]字符串最长回文串
     */
    public void huiwen() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            String sub = s.substring(l - 1, r);
            int min = sub.length();
            for (int j = 1; j <= sub.length(); j++) { //子串步长

            }

            System.out.println(min);
        }
    }

    boolean huiwen0(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }

        return s.charAt(0) == s.charAt(s.length() - 1) && huiwen0(s.substring(1, s.length() - 1));
    }

    /**
     * 刷板子最少次数
     */
    public void printBorad() { //同浇花题,找降序位置
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (i > 0 && a[i - 1] > a[i]) {
                if (flag) {
                    res += a[i - 1];
                    flag = false;
                } else {
                    //res =
                }

            }
        }

        System.out.println(res);
    }

    public void sum() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextInt();
            long max = 0;
            for (long j = 0; j <= n / 2; j++) {
                max = Math.max(max, sumL(j) + sumL(n - j));
            }

            System.out.println(max);
        }
    }

    private long sumL(long n) {
        long res = 0;
        while (n / 10 > 0) {
            res += n % 10;
            n /= 10;
        }
        res += n;

        return res;
    }

    /**
     * 从小到大第k个子串
     * 堆应该用PriorityQueue实现(底层也是数组,放满后会自动扩容)
     */
    public void kthSubStr() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        String[] res = new String[k + 1];

        int len = s.length(), size = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                size++;
                String tmp = s.substring(i, j);
                if (size <= k) {
                    res[size] = tmp;
                    if (size == k ) {
                        //调整最小堆
                        for (int l = k / 2; l >= 0; l--) {
                            int min = (res[l * 2].compareTo(res[l * 2] + 1) > 0) ? l * 2 + 1 : l * 2;
                            if (res[l].compareTo(res[min]) > 0) {
                                String tmp1 = res[l];
                                res[l] = res[min];
                                res[min] = tmp1;
                            }
                        }
                    }
                } else {

                }
            }
        }

        /*for (int i = 0; i < k; i++) {
            res.poll();
        }

        System.out.println(res.peek());*/
    }

    /**
     * 删除链表第k个节点
     */
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node deleteKthNode() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Node head = null, p = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (i == 0) {
                head = node;
                p = head;
            } else {
                if (i != m - 1) {
                    p.next = node;
                    p = node;
                }
            }
        }

        if (m == 1) {
            head = head.next;
        }
        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        return head;
    }
}
