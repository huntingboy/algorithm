package com.nomad.jzoffer;

public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return valu*e:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) { //数组中重复的数字
        int[] counts = new int[length];
        for (int i = 0; i < length; i++) {
            counts[numbers[i]]++;
        }
        for (int i = 0; i < length; i++) {
            if (counts[i] > 1) {
                duplication[0] = i;
                return true;
            }
        }

        return false;
    }
}
