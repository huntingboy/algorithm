package com.nomad.xz.wuba;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 58同城
 */
public class Main_21 {
    public static void main(String[] args) {
        System.out.println(new Main_21().calculate("1 + -2 / -2 + 4 1"));
    }

    /**
     * 合并数组
     * @param arrayA int整型ArrayList 数组A
     * @param arrayB int整型ArrayList 数组B
     * @return int整型ArrayList
     */
    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        int p = 0, q = 0;
        while (p < arrayA.size() && q < arrayB.size()) {
            if (arrayA.get(p) < arrayB.get(q)) {
                p++;
            } else if (arrayA.get(p) > arrayB.get(q)) {
                q++;
            } else {
                res.add(arrayA.get(p));
                p++;
                q++;
            }
        }

        return res;
    }

    /**
     * 二进制数目
     * @param num int整型 非负整数 num
     * @return int整型一维数组
     */
    public int[] countBits (int num) {
        // write code here
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countBit(i);
        }

        return res;
    }

    private int countBit(int i) {
        if(i == 0) return 0;
        int tmp = countBit(i >> 2);
        return (i % 2 == 1) ? tmp + 1 : tmp;
    }

    /**
     * 四则运算
     * @param input string字符串
     * @return int整型
     */
    public int calculate (String input) {
        // write code here
        if (input == null || input.trim().length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(input.trim());
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == ' ' && Character.isDigit(sb.charAt(i - 1)) && Character.isDigit(sb.charAt(i + 1))) {
                sb.deleteCharAt(i);
            }
        }
        input = sb.toString();

        int res = 0;
        String[] words = input.trim().split(" ");
        if (words.length == 1) {
            res = Integer.parseInt(words[0]);
        } else {
            Stack<Integer> opv = new Stack<>();
            opv.add(Integer.valueOf(words[0]));
            opv.add(Integer.valueOf(words[2]));
            Stack<Character> ops = new Stack<>();
            ops.add(words[1].charAt(0));
            for (int i = 3; i < words.length; i+=2) {
                char c = words[i].charAt(0);
                int tmp;
                switch (c) {
                    case '-':
                    case '+':
                        tmp = operate(opv.pop(), opv.pop(), ops.pop());
                        opv.add(tmp);
                        ops.add(c);
                        opv.add(Integer.valueOf(words[i + 1]));
                        break;
                    case '*':
                    case '/':
                        tmp = operate(opv.pop(), Integer.parseInt(words[i + 1]), c);
                        opv.add(tmp);
                        break;
                }
            }

            res = operate(opv.pop(), opv.pop(), ops.pop());
        }

        return res;
    }

    private int operate(int l, int r, char ops) {
        int res = 0;
        switch (ops) {
            case '+':
                res = l + r;
                break;
            case '-':
                res = l - r;
                break;
            case '*':
                res = l * r;
                break;
            case '/':
                res = l / r;
                break;
        }
        return res;
    }
}
