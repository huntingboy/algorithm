package com.nomad.jzoffer;

public class Multiply {
    public int[] multiply(int[] A) { //构建乘积数组 先求i之间的乘积，然后求i之后的乘积   n×n矩阵
        int[] B = new int[A.length];
        if (A.length != 0) {
            B[0] = 1;
            for (int i = 1; i < A.length; i++) { //计算i之前的乘积 从上往下(下三角)
                B[i] = B[i - 1] * A[i - 1];
            }

            int tmp = 1;
            for (int i = A.length - 2; i >= 0; i--) { //计算i之后的乘积 从下往上(上三角)
                tmp *= A[i + 1];
                B[i] *= tmp;
            }
        }
        return B;
    }
}
