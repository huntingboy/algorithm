package com.nomad.jzoffer;

import java.util.LinkedList;
import java.util.List;

public class GetMedian {

    List<Integer> nums = new LinkedList<>();  //因为经常insert,所以使用链表而不是数组
    public void insert(Integer num) {
        if (nums.size() == 0) {
            nums.add(num);
        } else {
            int i = 0;
            for (; i < nums.size(); i++) {
                if (nums.get(i) > num) { //按照增序方式存储所有值
                    nums.add(i, num);
                    break;
                }
            }
            if (i == nums.size()) { //如果num是最大的值，插入到最后
                nums.add(i, num);
            }
        }
    }

    public Double getMedian() { //数据流中的中位数
        int size = nums.size();
        double res = 0;
        if (size % 2 != 0) { //奇数个节点
            res = Double.valueOf(nums.get(size / 2));
        } else {//偶数个节点
            res = (nums.get(size / 2 - 1) + nums.get(size / 2)) / 2.0;
        }
        return res;
    }
}
