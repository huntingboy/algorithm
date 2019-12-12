package com.nomad.jzoffer;

public class Add {
    public int add(int num1,int num2) { //不用加减乘除做加法   ^:异或求和（忽略会产生进位的位）  &:求出所有会产生进位的位 然后左移1位  2者相加即可
        int a = num1 ^ num2;
        int b = num1 & num2;
        b = b << 1;
        if (b != 0) {
            a = add(a, b);
        }
        return a;
    }
}
