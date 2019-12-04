package com.nomad.jzoffer;

import java.util.Arrays;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        //空间换时间
        int[] odd = new int[array.length];
        int[] even = new int[array.length];

        int i = 0, j = 0, k = 0;
        for (; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even[j++] = array[i];
            } else {
                odd[k++] = array[i];
            }
        }

        for (i = 0; i < k; i++) {
            array[i] = odd[i];
        }
        for (; i < array.length; i++) {
            array[i] = even[i - k];
        }
//        System.out.println(Arrays.toString(array));
    }
}
