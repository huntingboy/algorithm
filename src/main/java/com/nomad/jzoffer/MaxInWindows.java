package com.nomad.jzoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) //滑动窗口的最大值  常规方法
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (num != null && num.length != 0 && size > 0 && size <= num.length) { //注意判断的条件
            for (int i = 0; i <= num.length - size; i++) {
                res.add(findMax(num, i, i + size));
            }
        }
        return res;
    }

    private Integer findMax(int[] num, int l, int h) {
        int max = num[l];
        for (int i = l + 1; i < h; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    public ArrayList<Integer> maxInWindows1(int [] num, int size) //滑动窗口的最大值  双端队列法
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (num != null && num.length != 0 && size > 0 && size <= num.length) {
            ArrayDeque<Integer> q = new ArrayDeque<>(); //记录每个窗口的最大值下标，队列第一个位置保存当前窗口的最大值
            int begin;//当前窗口的起始下标
            for (int i = 0; i < num.length; i++) {
                begin = i - size + 1;
                if (q.isEmpty()) {
                    q.add(i);
                }
                if (begin > q.peekFirst()) { //最大值如果过期就从队列移除
                    q.pollFirst();
                }
                while (!q.isEmpty() && q.peekLast() <= num[i]) { //从队列删除当前窗口包括后面窗口不可能的最大值的下标值
                    q.pollLast();
                }
                q.add(i);
                if (begin >= 0) {
                    res.add(num[q.peekFirst()]);
                }
            }
        }
        return res;
    }

}
