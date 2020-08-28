package com.nomad.xz.xm;

import java.util.Scanner;
public class Main_21 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        new Main_21().print("XIAOMIINTERVIEW");
    }

    /**
     * Z字类型打印
     */
    public void print(String str){
        StringBuilder[] res = new StringBuilder[3];
        for(int i = 0; i < str.length(); i++){
            if (res[i % 3] == null) {
                res[i % 3] = new StringBuilder();
            }
            res[i % 3].append(str.charAt(i));
        }

        for(int i = 0; i < 3; i++){
            System.out.println(res[i].toString());
        }
    }

    /**
     * 最大连续和
     * res, sum(遇到负数sum=0)
     */
}
