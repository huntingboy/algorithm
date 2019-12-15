package com.nomad.jzoffer;

public class HasPath {
    private int[][] visited; //标记格子在当前路径上是否被访问过
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) //矩阵中的路径
    {
        visited = new int[rows][cols];
        char[][] m = new char[rows][cols];
        for (int i = 0; i < rows; i++) {  //把matrix从一维转为二维,方便后面的比较
            for (int j = 0; j < cols; j++) {
                m[i][j] = matrix[i * cols + j];
            }
        }
        for (int i = 0; i < rows; i++) { //任意一个格子当做起始格子遍历
            for (int j = 0; j < cols; j++) {
                if (find(m, rows, cols, str, i, j, 0)) { //最后一个参数表示str的当前下标值
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] m, int rows, int cols, char[] str, int i, int j, int spos) {
        if (spos >= str.length) {
            return true;
        }
        if (i < 0 || i >= rows || j < 0 || j >= cols || m[i][j] != str[spos] || visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1; //置当前格子为已访问状态
        boolean res = find(m, rows, cols, str, i + 1, j, spos + 1) //往4个方向递归str后面的串
                || find(m, rows, cols, str, i - 1, j, spos + 1)
                || find(m, rows, cols, str, i, j + 1, spos + 1)
                || find(m, rows, cols, str, i, j - 1, spos + 1);
        visited[i][j] = 0; //重置当前格子未访问状态
        return res;
    }
}
