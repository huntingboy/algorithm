package com.nomad.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) { //得到数组最小的k个数 (工具类实现)
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k <= 0 || input.length == 0) {//合法性验证
            return result;
        }
        int[] tmp = input.clone();//数组深拷贝，不改变原有的数组
        Arrays.sort(tmp);
        for (int i = 0; i < k; i++) {
            result.add(tmp[i]);
        }

        return result;
    }

    public ArrayList<Integer> getLeastNumbers_Solution1(int[] input, int k) { //得到数组最小的k个数 (冒泡实现)
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k <= 0 || input.length == 0) {//合法性验证
            return result;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] < input[j+1]) {
                    int tmp = input[j];
                    input[j] = input[j + 1];
                    input[j+1] = tmp;
                }
            }
            result.add(input[input.length - 2 - i]);
        }
        return result;
    }

    public ArrayList<Integer> getLeastNumbers_Solution2(int[] input, int k) { //得到数组最小的k个数 (堆排序)
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k <= 0 || input.length == 0) {//合法性验证
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //o2：parent  >0则break  默认是小顶堆o1.compareTo(o2)
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]); //offer插入失败会返回false，而add会抛出异常    堆的插入，调整由底向上，
            } else if (maxHeap.peek() > input[i]) {
                Integer tmp = maxHeap.poll(); //poll()会删除array[0],如果没有返回Null；remove则会抛出异常.   堆的删除，调整自顶向下，
                tmp = null;
                maxHeap.offer(input[i]);
            }
        }

        for (Integer i : maxHeap) {
            result.add(i);
        }
        return result;
    }
}
