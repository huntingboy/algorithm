package com.nomad.xz.jd;

import java.util.Scanner;

public class Main_21 {
    public static void main(String[] args) {
        while (true) {
            new Main_21().findKthNumber();
        }
    }

    /**
     * 235可重复选取,从小到大第k个数
     * 2 3 5
     *
     * 22 23 35
     * 32 33 35
     * 52 53 55
     *
     * 222 223 225
     * 232 233 235
     * ...
     *
     * 找规律:
     * 1.计算第k个数有几位bitCount,定义结果数组res[bitCount]
     * 2.计算距离bitCount-1位最大的数的行差delta
     * 3.根据规律填充res[bitCount]
     * 还可用树的bfs来做(3棵树)
     */
    public void findKthNumber() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = (int) Math.ceil(n / 3f);
        int col = n % 3;
        int bitCount = calBitCount(2 * row + 1);
        int rowBefore = (int) ((Math.pow(3, bitCount - 1) - 1) / 2);
        int[] res = new int[bitCount];
        int delta = row - rowBefore;
        for (int i = bitCount - 2; i >= 0; i--) {// e.g. n=4: 第一次,根据delta/3^2%3计算res[0],第二次,根据delta/3^1%3计算res[1],第三次,根据delta/3^0%3计算res[2]
            int tmp = (int) Math.ceil(delta / Math.pow(3, i)) % 3;
            switch (tmp) {
                case 1:
                    res[bitCount - 2 - i] = 2;
                    break;
                case 2:
                    res[bitCount - 2 - i] = 3;
                    break;
                case 0:
                    res[bitCount - 2 - i] = 5;
                    break;
            }
        }
        switch (col) {//计算res[3]
            case 1:
                res[bitCount - 1] = 2;
                break;
            case 2:
                res[bitCount - 1] = 3;
                break;
            case 0:
                res[bitCount - 1] = 5;
                break;
        }

        for (int i = 0; i < bitCount; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
    }

    private int calBitCount(int n) {
        int res = 1;
        while (n > Math.pow(3, res)) {
            res++;
        }

        return res;
    }

    /**
     * 滚雪球的最大值
     *   1
     *  2 3
     * 1 2 3
     *4 5 1 3
     * dp
     */
}
