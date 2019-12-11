package com.nomad.jzoffer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) { //和为S的两个数字 穷举 双指针（窗口）技术
        ArrayList<Integer> result = new ArrayList<>();
        int l = 0, h = array.length - 1;
        int tmp = Integer.MAX_VALUE;
        while (l < h) {
            if (array[l] + array[h] < sum) {
                l++;
            } else if (array[l] + array[h] > sum) {
                h--;
            } else {
                if (array[l] * array[h] < tmp) {
                    result.clear();
                    result.add(array[l]);
                    result.add(array[h]);
                }
                tmp = array[l] * array[h]; //更新操作
                l++;
                h--;
            }
        }
        return result;
    }
}
