package com.nomad.main;

public class NumberDivide {

    static int[] mark = new int[100]; //记录分解情况
    static int n;

    public static void divide(int now, int k, int pre){
        int i;
        //数组长度大于n就返回
        if (now > n) return;

        if (now == n) {
            System.out.printf("%d=", n);
            for (i = 0; i < k - 1; i++) {
                System.out.printf("%d+", mark[i]);
            }
            System.out.printf("%d\n", mark[i]);
        } else {
            for (i = pre; i > 0; i--) {
                if (i <= pre) {
                    mark[k] = i;
                    now += i;
                    divide(now, k + 1, i);
                    now -= i;
                }
            }
        }
    }
}
