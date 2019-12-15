package com.nomad.jzoffer;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) { //遇到梯度(旋转支点)下标位置  后面的都不用再比较了
                min = array[i + 1];
                break;
            }
        }

        return min;
    }
}
