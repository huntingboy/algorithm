package com.nomad.jzoffer;

public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = array[0];  //记录所有连续子元素的最大和
        int max = array[0];  //记录当前连续子元素的最大和
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
