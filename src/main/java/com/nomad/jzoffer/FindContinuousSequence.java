package com.nomad.jzoffer;

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) { // 和为S的连续正数序列  穷举 双指针(i指向最小值，j指向最大值)
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        for (int i = 1; i <= sum / 2; i++) {
            int j = i + 1;
            while ((i + j) * (j + 1 - i) < sum * 2) j++;
            if ((i + j) * (j + 1 - i) == sum * 2) {  //找到一个连续序列
                ArrayList<Integer> result = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    result.add(k);
                }
                results.add(result);
            }
        }
        return results;
    }
}
