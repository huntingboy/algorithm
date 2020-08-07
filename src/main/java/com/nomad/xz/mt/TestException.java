package com.nomad.xz.mt;

public class TestException {
    public static void main(String[] args) {
        int i = 0;
        int res = 1;
        while(true) {
            try {
                res += res / i++; //i++会执行  类似题：i=0; i=i++; 最后i=0 （因为第一步：i++这个表达式会返回 0，但此时 i = 1； 第二步：将返回值 0 赋值给 i ；第三步： i 又被更改为 0，所以输出 0 )
                System.out.println("No exception");
            } catch(Exception e) {
                System.out.println("Zero exception");
            } finally {
                System.out.print("In finally clause");
                System.out.println(i);
                if (i == 2) break;
            }
        }
    }
}
