package com.nomad.xz.ne;
import java.util.Scanner;

public class Main_21 {
    public static void main(String[] args) {
        new Main_21().avg();
    }

    /**
     * 生成树中输出最大权值和最小权值差最小
     * todo
     */
    public void tree(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] w = new int[n][m];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            w[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        System.out.println(2);
    }

    /**
     * 把物品分配给2人,使价值相等,输出最小扔掉的价值
     * todo
     */
    public void avg(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n  = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[i] = sc.nextInt();
            }

            System.out.println(a[n - 1] - a[0]);
        }
    }

    /**
     * 最小字典序列
     * fixme
     */
    public void seq(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[m];
        boolean[] a = new boolean[100001];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            a[nums[i]] = true;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < nums[i]; j++) {
                if (!a[j]) {
                    a[j] = true;
                    count++;
                    System.out.print(j + " ");
                }
            }
            count++;
            System.out.print(nums[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        for (int i = count + 1; i <= n; i++) {
            System.out.print(i);
            if (i < n) {
                System.out.print(" ");
            }
        }
    }

    /**
     * 每个数可拆分,输出最多的素数总个数
     */
    public void sushuCounts(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            res += a[i] / 2;
        }

        System.out.println(res);
    }
}
