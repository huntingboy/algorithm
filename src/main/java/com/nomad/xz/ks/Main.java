package com.nomad.xz.ks;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author nomad
 * @create 2020-09-02 9:31 PM
 */
public class Main {
    public static void main(String[] args) {
        new Main().factorialNotZero();
    }

    /**
     * KS
     * 阶乘末尾非0的个数
     */
    public void factorialNotZero(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i = 1, res = 0;
        while (i * 5 <= n) {
            res++;
            i++;
        }

        System.out.println("factorial(n) = " + factorial(n));
        System.out.println(("" + factorial(n)).length() - res);
    }

    private long factorial(int n) {
        if (n < 2) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    /**
     * KS31
     * 最长公共子串
     */
    public void commonSubStr(){
        Scanner sc = new Scanner(System.in).useDelimiter(",");
        String s1 = sc.next(), s2 = sc.next();
        int len1 = s1.length(), len2 = s2.length(), res = Integer.MIN_VALUE;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        System.out.println(res);
    }

    /**
     * KS9
     * 字符串排序
     */
    public void stringSort(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<String> res = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            res.offer(s.substring(s.length() - 6));
        }

        int size = res.size();
        for (int i = 0; i < size; i++) {
            System.out.println(res.poll());
        }
    }

    public static void testQueue() {
        Queue<String> res = new PriorityQueue<>();
        res.add("a");
        res.add("d");
        res.add("c");
        res.add("a");
        res.add("b");
        res.add("d");
        int size = res.size();
        for (int i = 0; i < size ; i++) {
            System.out.println(res.poll());
        }

        for (String re : res) {
            System.out.println(re);
        }
    }

    /**
     * KS4
     * 最少数量货物装箱问题
     * 对7取余，对余数进行讨论即可
     * 余数为1,3,5，则可以装满，1可以视为1+7=3+5，依旧是之前的count+1
     * 余数为2,4,6，也可以装满，2可以视为2+7=3+3+3，4可以视为4+7=5+3+3，6=3+3是之前的count+2
     */
    public void minGoods(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1 || n == 2 || n == 4) {
            System.out.println(-1);
            return;
        }

        int counts = n / 7;
        switch (n % 7) {
            case 1:
            case 3:
            case 5:
                counts++;
                break;
            case 2:
            case 4:
            case 6:
                counts += 2;
                break;
        }
        System.out.println(counts);
    }

    /**
     * KS1
     * 获得最多的奖金
     */
    public void maxBonus(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int l = 0, r = n - 1;
        long[] sum = new long[]{nums[l], nums[r]};
        long res = 0;
        while (l < r) {
            if (sum[0] == sum[1]) {
                res = Math.max(res, sum[0]);
                sum[0] += nums[++l];
                sum[1] += nums[--r];
            } else if (sum[0] < sum[1]) {
                sum[0] += nums[++l];
            } else {
                sum[1] += nums[--r];
            }

        }

        System.out.println(res);
    } 
}
