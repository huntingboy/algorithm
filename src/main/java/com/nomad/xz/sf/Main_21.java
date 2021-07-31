package com.nomad.xz.sf;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 顺丰
 */
public class Main_21 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            System.out.println(findNumber(i)[0]);
            System.out.println(findNumber(i)[1]);
        }
    }

    /**
     * 满足条件的临近二进制数
     */
    static int[] findNumber(int num) {
        int[] res = new int[2];
        char[] chars = new char[32];
        Arrays.fill(chars, '0');
        String str = Integer.toBinaryString(num);
        int len = str.length();
        System.arraycopy(str.toCharArray(), 0, chars, 32 - len, len);
        //找最后一个10串
        int i = len - 2;
        for (; i >= 0; i--) {
            char c0 = str.charAt(i);
            char c1 = str.charAt(i + 1);
            if (c0 == '1' && c1 == '0') {
                break;
            }
        }
        if (i >= 0) {
            StringBuilder sb = new StringBuilder(str);
            sb.replace(i, i + 2, "01");
            res[1] = Integer.parseInt(sb.toString(), 2);
        } else {
            res[1] = -1;
        }

        //找最后一个01串
        for (i = 30; i >= 0; i--) {
            char c0 = chars[i];
            char c1 = chars[i + 1];
            if (c0 == '0' && c1 == '1') {
                break;
            }
        }
        if (i > 0) {
            chars[i] = '1';
            chars[i + 1] = '0';
            if (i + 2 < 32 && chars[i + 2] == '1') {
                int count = 1;
                for (int j = i + 3; j < 32; j++) {
                    if (chars[j] == '1') count++;
                }
                Arrays.fill(chars, i + 2, i + 2 + count, '0');
                Arrays.fill(chars, 32 - count, 32, '1');
            }
            /*int sum = 0;
            for (int j = 0; j < 32; j++) {
                if (chars[j] == '1') {
                    sum += 1;
                }
                sum = sum << 1;
            }
            res[0] = sum >> 1;*/
            res[0] = Integer.parseInt(String.valueOf(chars), 2);
        } else {
            res[0] = -1;
        }

        return res;
    }

    /**
     * 最长有效括号
     */
    static int longestValidParenthe(String s) {
        int len = s.length();
        Stack<Integer> res = new Stack<>(); //存放(下标
        int ret = 0;
        res.add(0);
        for (int i = 1; i <= len; i++) {
            char c = s.charAt(i - 1);
            if (c == '(') {
                res.add(i);
            } else {
                res.pop();
                if (res.isEmpty()) {
                    res.add(i);
                } else {
                    ret = Math.max(ret, i - res.peek());
                }
            }
        }

        return  ret;
    }
}
