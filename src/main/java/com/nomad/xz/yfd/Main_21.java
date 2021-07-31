package com.nomad.xz.yfd;

import java.util.Scanner;

/**
 * 猿辅导
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x3();
    }

    /**
     * 小袁的纸条
     */
    int res = 0;
    public void x3(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            String s = sc.next();
            int k = sc.nextInt();
            int i1 = 0, i2 = 0, i3 = 0;

            if (x30(s1, i1, s2, i2, s, i3, k, -1)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    private boolean x30(String s1, int i1, String s2, int i2, String s, int i3, int k, int lasti) {
        if (i3 == s.length()) {
            return true;
        }
        if (k == 0 || i1 == s1.length() && i2 == s2.length()) {
            return false;
        }

        char c1 = ' ', c2 = ' ';
        if(i1 < s1.length())  c1 = s1.charAt(i1);
        if(i2 < s2.length()) c2 = s2.charAt(i2);
        char c3 = s.charAt(i3);
        i3++;
        boolean res = false;
        if (c3 == c1) {
            if(lasti == 2) k--;
            res = res || x30(s1, i1 + 1, s2, i2, s, i3, k, 1);
        }
        if (c3 == c2) {
            if(lasti == 1) k--;
            res = res || x30(s1, i1, s2, i2 + 1, s, i3, k, 2);
        }

        return res;
    }

    /**
     * 前缀表达式求解
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int MOD = (int) 1e7;
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            if (!s.trim().startsWith("(") || !s.trim().endsWith(")")) {
                System.out.println("invalid");
                continue;
            }

            String[] words = s.trim().substring(1, s.trim().length() - 1).split(" ");
            char c0 = words[0].charAt(0);
            if (c0 != '+' && c0 != '-' && c0 != '*') {
                System.out.println("invalid");
                continue;
            }

            long res = 0;
            switch (c0) {
                case '+':
                    res = Integer.parseInt(words[1]) + Integer.parseInt(words[2]);
                    break;
                case '-':
                    res = Integer.parseInt(words[1]) - Integer.parseInt(words[2]);
                    break;
                case '*':
                    res = Integer.parseInt(words[1]) * Integer.parseInt(words[2]);
                    break;
            }

            res = (res % MOD + MOD) % MOD;
            System.out.println(res);
        }
    }

    /**
     * 小袁的扑克牌魔术
     */
    public void x1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n];
            int mid = n / 2;
            for (int j = 0; j < mid; j++) {
                tmp[2 * j] = nums[mid + j];
                tmp[2 * j + 1] = nums[j];
            }
            nums = tmp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
            if (i == n - 1) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
