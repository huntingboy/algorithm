package com.nomad.jzoffer;

public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) //机器人的运动范围
    {
        int[][] visited = new int[rows][cols];
        return calMovingCount(0, 0, rows, cols, visited, threshold); //前两个参数为当前格子位置  一般递归函数的参数都是固定的，可以记住
    }

    private int calMovingCount(int i, int j, int rows, int cols, int[][] visited, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] == 1 || (numSum(i) + numSum(j) > threshold)) {
            return 0;
        }
        visited[i][j] = 1; //当前格子符合要求,并且只能计算一次
        return calMovingCount(i - 1, j, rows, cols, visited, threshold)
                + calMovingCount(i + 1, j, rows, cols, visited, threshold)
                + calMovingCount(i, j - 1, rows, cols, visited, threshold)
                + calMovingCount(i, j + 1, rows, cols, visited, threshold)
                + 1;
    }

    private int numSum(int n) {//计算n的各个位之和
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
