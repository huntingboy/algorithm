package com.nomad.sort;

import com.nomad.jzoffer.Matrix;
import com.nomad.jzoffer.NumberOf1;
import com.nomad.jzoffer.Power;
import com.nomad.jzoffer.ReOrderArray;
import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class TestAll {
    @Test
    public void testNumberOf(){
        System.out.println(new NumberOf1().numberOf1(214748367));
        System.out.println(new NumberOf1().numberOf1(5));
        System.out.println(new NumberOf1().numberOf1(-5));
        System.out.println(new NumberOf1().numberOf1(-1));
    }


    @Test
    public void testPower() { //test无法读取控制台输入，放到main里面执行
        Scanner scanner = new Scanner(System.in);
        double base;
        int exponent;
        while (scanner.hasNext()) {
            base = scanner.nextDouble();
            exponent = scanner.nextInt();
            System.out.println(new Power().power(base, exponent));
        }
    }

    @Test
    public void testReOrderArray(){
        new ReOrderArray().reOrderArray(new int[]{1,2,3,4,6,5});
    }
}
