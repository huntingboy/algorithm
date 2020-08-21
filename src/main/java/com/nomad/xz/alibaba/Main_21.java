package com.nomad.xz.alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Main_21 {
    public static void main(String[] args) {
        new Main_21().crossRiver();
    }

    /**
     * 过河问题
     * 递归
     */
    public void crossRiver(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a); //按体重升序排列
            int res = crossRiver0(a, n);
            System.out.println(res);
        }
        sc.close();
    }

    private int crossRiver0(int[] a, int n) {
        if (n < 3) return a[n - 1];
        if (n == 3) return a[2] + a[0] + a[1];

        //每次送2个最大的数到河对岸
        int t1 = a[1] + a[0] + a[n - 1] + a[1];  //方式一
        int t2 = a[n - 1] + a[0] + a[n - 2] + a[0]; //方式二
        int t = Math.min(t1, t2);
        return crossRiver0(a, n - 2) + t;
    }
}
