package com.nomad.jzoffer;

import java.util.HashMap;

public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) { //数组中只出现一次的数字  hashmap方法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                } else {
                    num2[2] = array[i];
                }
            }
        }
    }

    public void findNumsAppearOnce1(int [] array,int num1[] , int num2[]) { //数组中只出现一次的数字  妙解：位运算方法
        int xor1 = 0;
        for (int i = 0; i < array.length; i++) { //求出所有元素的异或  最后结果为不同的2个元素的异或值
            xor1 ^= array[i];
        }
        int index = (~xor1 + 1) & xor1; //取反+1:所有位取反直到最后一个1不变   index:指向xor1最后一个值为1的bit
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0) { //根据index分组，不同的2个数肯定分到了不同的组，相同的数会分到同一个组，但是异或后为零
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
