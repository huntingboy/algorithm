package com.nomad.jzoffer;

import java.util.ArrayList;

public class Matrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();

        /*if (matrix.length == 1) { //只有一行
            for (int j = 0; j < matrix[0].length; j++) {
                result.add(matrix[0][j]);
                System.out.println(matrix[0][j]);
            }
        } else if (matrix[0].length == 1) { //只有一列
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
                System.out.println(matrix[i][0]);
            }
        } else { *///矩阵，包括方阵
            for (int i = 0, j = 0; i < Math.min(matrix.length, matrix[0].length) / 2.0; i++, j++) {
                int is = i;
                int ie = matrix.length - is;
                int js = j;
                int je = matrix[0].length - js;
                if (js + 1 == je && is + 1 == ie) { //循环n圈后，最后只剩下一个数会进入
                    result.add(matrix[is][js]);
                    System.out.println(matrix[is][js]);
                } else if (js + 1 == je) { //循环n圈后，最后只剩下一列会进入
                    while (is < ie) {
                        System.out.println(matrix[is][js]);
                        result.add(matrix[is++][js]);
                    }
                } else if (is + 1 == ie) {  //循环n圈后，最后只剩下一行会进入
                    while (js < je) {
                        System.out.println(matrix[is][js]);
                        result.add(matrix[is][js++]);
                    }
                } else { //循环每一圈
                    while (js < je - 1) { //j++, 从左到右，不包括最后一列
                        result.add(matrix[is][js]);
                        System.out.println(matrix[is][js]);
                        js++;
                    }
                    //i++ 从上到下，不包括最后一行
                    while (is < ie - 1) {
                        result.add(matrix[is][js]);
                        System.out.println(matrix[is][js]);
                        is++;
                    }
                    //j-- 从右到左，不包括最前列
                    while (js > j) {
                        result.add(matrix[is][js]);
                        System.out.println(matrix[is][js]);
                        js--;
                    }
                    //i-- 从下到上，不包括最上一行
                    while (is > i) {
                        result.add(matrix[is][js]);
                        System.out.println(matrix[is][js]);
                        is--;
                    }
                }
            }
//        }

        return result;
    }
}
