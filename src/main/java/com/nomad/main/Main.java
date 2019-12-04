package com.nomad.main;

import com.nomad.jzoffer.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public void testPower() {
        Scanner scanner = new Scanner(System.in);
        double base;
        int exponent;
        while (scanner.hasNext()) {
            base = scanner.nextDouble();
            exponent = scanner.nextInt();
            System.out.println(new Power().power(base, exponent));
        }
    }

    public void testMatrix() {
        Matrix matrix = new Matrix();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[][] array = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            matrix.printMatrix(array);
        }
    }

    public void testPopOrder() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] pushA = new int[N];
            int[] popA = new int[N];
            for (int i = 0; i < N; i++) {
                pushA[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                popA[i] = scanner.nextInt();
            }

            MyStack myStack = new MyStack();
            System.out.println(myStack.isPopOrder(pushA, popA));
        }
    }



}
