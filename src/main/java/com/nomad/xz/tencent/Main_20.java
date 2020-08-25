package com.nomad.xz.tencent;

import java.util.Scanner;

public class Main_20 {
    public static void main(String[] args) {
        new Main_20().wandering();
    }

    /**
     * 逛街
     * 从当前位置向两侧找递增子序列（可以非连续）
     * 0.6ac
     */
    public void wandering(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(descendLen(h, i) + ascendLen(h, i + 1) + 1);
            System.out.print(" ");
        }
    }

    private int descendLen(int[] h, int end) {
        int res = 0;
        if (end > 0) {
            int first = h[end - 1];
            res++;
            while (--end > 0) {
                if (h[end - 1] >= first) {
                    first = h[end - 1];
                    res++;
                }
            }
        }

        return res;
    }

    private int ascendLen(int[] h, int start) {
        int res = 0;
        if (start < h.length) {
            int first = h[start];
            res++;
            while (++start < h.length) {
                if (h[start] >= first) {
                    first = h[start];
                    res++;
                }
            }
        }

        return res;
    }


    /**
     * 字符串固定格式解压缩
     */
    public void unzip(){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            if (str != null && str.length() > 0) {
                System.out.println(new Main_20().unzip0(str, 0, str.length()));
            } else {
                System.out.println("");
            }
        }
    }

    public String unzip0(String input, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        while (begin < end) { // [ 前面部分
            if (input.charAt(begin) == '[') {
                break;
            }
            sb.append(input.charAt(begin));
            begin++;
        }
        //普通的串ab
        if (begin == end) {
            return sb.toString();
        }

        //ab[3|bc]de
        int num = 0, end1 = input.lastIndexOf(']', end - 1);
        char ch;
        while ((ch = input.charAt(++begin)) != '|') { //得到数字
            num = num * 10 + ch - '0';
        }
        String middle = unzip0(input, begin + 1, end1); //递归取中间部分
        while (num-- > 0) { //num次Middle中间部分
            sb.append(middle);
        }
        sb.append(input.substring(end1 + 1, end)); // ] 后面部分
        return sb.toString();
    }
}
