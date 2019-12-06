package com.nomad.jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public ArrayList<String> permutation(String str) { //打印串的字典排序的所有序列
        ArrayList<String> list = new ArrayList<>();
        if (str!=null && str.length()>0) {
            permutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private void permutationHelper(char[] chars, int i, List<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            for (int j = i; j < chars.length; j++) {
                if (i != j && chars[i] == chars[j]) { //对于重复元素跳过，不处理
                    continue;
                }
                swap(chars, i, j);
                permutationHelper(chars, i+1, list);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        if (i == j) {
            return;
        } else {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}
