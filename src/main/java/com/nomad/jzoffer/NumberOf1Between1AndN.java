package com.nomad.jzoffer;

public class NumberOf1Between1AndN {
    public int numberOf1Between1AndN_Solution(int n) { //1~N间1的次数  枚举法
        int count = 0;
        while (n > 0) {
            String s = String.valueOf(n);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    public int numberOf1Between1AndN_Solution1(int n) { //1~N间1的次数  妙解
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}
