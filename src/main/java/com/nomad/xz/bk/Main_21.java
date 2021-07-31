package com.nomad.xz.bk;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 贝壳
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x4();
    }

    /**
     * 4，打怪初始血量
     */
    int minLife = Integer.MAX_VALUE;
    public void x4() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[2 * n + 1];
        int[] b = new int[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i == n) {
                continue;
            }
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i == n) {
                continue;
            }
            b[i] = sc.nextInt();
        }

        x40(a, b, n, Integer.MAX_VALUE, n, n);
        System.out.println(minLife);
    }

    /**
     * @param a       损失的血量集合
     * @param b       补几的血量集合
     * @param n       0...n-1,n,n+1...2n
     * @param curLife 当前血量
     * @param l       n左侧最后一次打怪的下标
     * @param r       n右侧最后一次打怪的下标
     */
    private void x40(int[] a, int[] b, int n, int curLife, int l, int r) {
        if (curLife <= 0) {
            return;
        }
        if (l == 0 && r == 2 * n) {
            minLife = Math.min(minLife, curLife);
        }


    }

    /**
     * 3，涂栅栏方案数
     */
    int res = 0;
    static final int MOD = 1000000007;
    public void x3() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            Set<Integer>[] notPlace = new HashSet[m + 1];
            for (int i1 = 1; i1 <= m; i1++) {
                for (int i2 = 0; i2 < k; i2++) {
                    if (notPlace[i1] == null) {
                        notPlace[i1] = new HashSet<>();
                    }
                    notPlace[i1].add(sc.nextInt());
                }
            }

            x30(m, 0, notPlace, n, 0);

            System.out.println(res);
            res = 0;
        }
    }

    /**
     * @param m 总颜色数
     * @param j 上个板子使用的颜色
     * @param notPlace 记录每种颜色后面不能放的颜色集合
     * @param n 板子总数
     * @param i 已经刷的板子数量
     */
    private void x30(int m, int j, Set<Integer>[] notPlace, int n, int i) {
        if (i == n) {
            res++;
            if (res >= MOD) {
                res %= MOD;
            }
            return;
        }

        for (int k = 1; k <= m; k++) {
            if (i == 0) { //第一个板子可以刷任意颜色k
                x30(m, k, notPlace, n, 1);
            } else {
                if (!notPlace[j].contains(k)) {
                    x30(m, k, notPlace, n, i + 1);
                }
            }
        }
    }

    /**
     * 2、构造字符串，本质是求最长重复子串
     */
    public void x2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int len = str.length();
        int maxRep = 1;
        int l = 0;
        for (int r = l + 1; r < len; r++) {
            if (r - l + 1 > maxRep) {
                String sub = str.substring(l, r + 1);
                String tmp = str.replaceFirst(sub, "*");
                if (tmp.contains(sub)) {
                    maxRep = r - l + 1;
                }
            }
        }
        System.out.println(len - maxRep + 1);
    }

    /**
     * 1、剪刀石头布
     */
    public void x1() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            char[] chs = new char[4];
            for (int j = 0; j < 4; j++) {
                chs[j] = sc.next().charAt(0);
            }

            int l_win = 0, r_win = 0;
            l_win = win(chs, chs[0]);
            r_win = win(chs, chs[1]);
            if (l_win == r_win) {
                System.out.println("same");
            } else if (l_win < r_win) {
                System.out.println("right");
            } else {
                System.out.println("left");
            }
        }
    }

    private int win(char[] chs, char ch) {
        int res = 0;
        for (int i = 2; i < 4; i++) {
            switch (ch) {
                case 'S':
                    if (chs[i] == 'J') {
                        res++;
                    }
                    break;
                case 'J':
                    if (chs[i] == 'B') {
                        res++;
                    }
                    break;
                case 'B':
                    if (chs[i] == 'S') {
                        res++;
                    }
                    break;
            }
        }
        return res;
    }
}
