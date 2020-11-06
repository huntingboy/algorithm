package com.nomad.xz.mc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 美菜
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x2();
    }

    /**
     * 字符串转数字 StrToInt
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s == null || s.trim().length() == 0) {
            System.out.println("0");
            return;
        }

        s = s.trim();
        boolean flag = true;
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                if (first && (c == '+' || c == '-')) {
                    first = false;
                    flag = false;
                } else {
                    break;
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            if (flag) {
                System.out.println(sb.toString());
            } else {
                System.out.print("-");
                System.out.println(sb.toString());
            }
        } else {
            System.out.println(0);
        }
    }

    /**
     * 顺时针打印矩阵
     */
    public void x1(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] rows = s.split("#");
        int[][] nums = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] words = rows[i].split(",");
            nums[i] = new int[words.length];
            for (int j = 0; j < words.length; j++) {
                nums[i][j] = Integer.parseInt(words[j]);
            }
        }

        int u = 0, d = rows.length - 1, l = 0, r = nums[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) {
                res.add(nums[u][i]);
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res.add(nums[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res.add(nums[d][i]);
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res.add(nums[i][l]);
            }
            if (++l > r) {
                break;
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) {
                System.out.print(",");
            }else
                System.out.println();
        }
    }
}
