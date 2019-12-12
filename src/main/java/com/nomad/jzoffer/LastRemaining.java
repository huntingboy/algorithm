package com.nomad.jzoffer;

import java.util.LinkedList;

public class LastRemaining {
    public int lastRemaining_Solution(int n, int m) {  //孩子们的游戏(圆圈中最后剩下的数)  约瑟夫环
        if (n <= 0) {
            return -1;
        }
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
        int index = 0, count = n;
        while (count > 1) {
            index = (index + m - 1) % count;
            numbers.remove(index);
            count--;
        }

        return numbers.get(0);
    }

    public int lastRemaining_Solution1(int n, int m) {  //约瑟夫环  通过归纳找出递归关系 f[1]=0; f[i]=(f[i-1]+m)%i (i>1)
        if (n == 0) {
            return -1;
        } else if (n == 1) {
            return 0;
        }else
            return (lastRemaining_Solution1(n - 1, m) + m) % n;
    }
}
