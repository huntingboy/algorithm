package com.nomad.jzoffer;

public class Sum {
    public int sum_Solution(int n) { //求1+2+3+...+n   短路求值
        boolean b = (n != 0) && ((n += sum_Solution(n - 1)) != 0);
        return n;
    }
}
