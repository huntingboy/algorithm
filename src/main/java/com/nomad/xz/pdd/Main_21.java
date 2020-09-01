package com.nomad.xz.pdd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
