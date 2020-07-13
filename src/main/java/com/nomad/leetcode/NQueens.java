package com.nomad.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nomad
 * @create 2020-07-13 5:21 PM
 */
public class NQueens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<List<String>> lists = new NQueens().solveNQueens(n);
            for (int i = 0; i < lists.size(); i++) {
                System.out.println("解法i = " + i);
                List<String> strings = lists.get(i);
                for (int j = 0; j < strings.size(); j++) {
                    System.out.println("strings.get(j) = " + strings.get(j));
                }
            }
        }
    }

    //N皇后 回溯
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }

        //定义状态变量
        boolean[][] flag = new boolean[n][n];

        doSolveNQueens(n, 0, flag, res);

        return res;
    }

    private void doSolveNQueens(int n, int i, boolean[][] flag, List<List<String>> res) { //n表示皇后个数(数组长度)， i表示当前要放置皇后的行
        if (i == n) { //成功的一种状态
            addSolution(flag, res);
            return;
        }
        for (int j = 0; j < n; j++) { //从第0行开始，尝试每一列放皇后
            if (canPutQuene(i, j, flag)) {
                flag[i][j] = true; //置已访问
                doSolveNQueens(n, i + 1, flag, res);
                flag[i][j] = false; //状态重置
            }
        }

    }

    private void addSolution(boolean[][] flag, List<List<String>> res) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < flag.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < flag[0].length; j++) {
                if (flag[i][j]) { //(i,j)放置有皇后
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            solution.add(sb.toString());
        }
        res.add(solution);
    }

    private boolean canPutQuene(int i, int j, boolean[][] flag) {
        int len = flag.length;
        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                if (flag[k][l] && (j == l || Math.abs(i - k) == Math.abs(j - l))) {
                    return false;
                }
            }
        }
        return true;
    }

    //N皇后 II
    private int res = 0; //解的数量
    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        boolean[][] flag = new boolean[n][n];

        doSolveNQueens(n, 0, flag);

        return res;
    }

    private void doSolveNQueens(int n, int i, boolean[][] flag) { //n表示皇后个数(数组长度)， i表示当前要放置皇后的行
        if (i == n) {
            res++;//解数加1
            return;
        }

        for (int j = 0; j < n; j++) {//尝试每一列放皇后
            if (canPutQuene(i, j, flag)) {
                flag[i][j] = true;
                doSolveNQueens(n, i + 1, flag);
                flag[i][j] = false;
            }
        }
    }
}
