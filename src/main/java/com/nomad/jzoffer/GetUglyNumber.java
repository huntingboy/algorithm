package com.nomad.jzoffer;

public class GetUglyNumber {
    public int getUglyNumber_Solution(int index) {  //输出第index个丑数（2^x3^y5^z）  牛客超时
        if (index <= 0) {
            return 0;
        }
        for (int i = 1; ; i++) {
            if (isUglyNumber(i)) {
                index--;
                if (index == 0) {
                    return i;
                }
            }
        }

//        return 0;
    }

    private boolean isUglyNumber(int i) {
        if (i == 1) {
            return true;
        }

        int[] a = {30, 15, 10, 6, 5, 3, 2};
        for (int j = 0; j < 7; j++) {
            while (i % a[j] == 0) {
                i /= a[j];
            }
        }

        return (i == 1);
    }


    public int getUglyNumber_Solution1(int index){ //输出第index个丑数（2^x3^y5^z） 妙解 空间换时间
        if (index <= 0) {
            return 0;
        }

        int[] res = new int[index];
        res[0] = 1; //第一个丑数为1
        int p2 = 0; //索引  res[p2]*2   基于这3个值，取最小值放到res数组中
        int p3 = 0; //索引  res[p3]*3
        int p5 = 0; //索引  res[p3]*5
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            if (res[i] == res[p2] * 2) p2++;
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
        }
        return res[index - 1];
    }
}
