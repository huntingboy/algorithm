package com.nomad.jzoffer;

import java.util.TreeSet;

public class IsContinuous {
    public boolean isContinuous(int [] numbers) { //扑克牌顺子 1.长度为5  2.0的个数+非重复非零元素个数=5  3.max-min<5
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int min = 14, max = -1;
        int count = 0; //记录0的个数
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            } else {
                set.add(numbers[i]);
            }
        }
        if (set.size() + count != 5) {
            return false;
        }
        max = set.last();
        min = set.first();
        if (max - min < 5) {
            return true;
        }

        return false;
    }
}
