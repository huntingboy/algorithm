package com.nomad.jzoffer;

import java.util.HashMap;

public class MoreThanHalfNum {
    public int moreThanHalfNum_Solution(int [] array) { //数组中出现次数超过一半的数字
        HashMap<Integer, Integer> map = new HashMap<>();
        final int len = array.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(array[i])) {//如果map有该key, 若没有该判断，下面的get会返回null，出错
                if (map.get(array[i]) + 1 > len / 2.0) {
                    return array[i];
                } else {
                    map.put(array[i], map.get(array[i]) + 1); //旧key-value的覆盖
                }
            } else {
                if (len == 1) {
                    return array[i];
                } else {
                    map.put(array[i], 1);
                }
            }
        }
        return 0;
    }
}
