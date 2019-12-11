package com.nomad.jzoffer;

public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) { //数字在排序数组中出现的次数
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (k == array[i]) {
                count++;
                flag = true;
            } else if (flag) {  //对于排好序的数组，后面不会再有k
                break;
            }
        }

        return count;
    }
}
