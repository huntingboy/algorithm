package com.nomad.main;

import com.nomad.jzoffer.*;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //new Main_20().testSerialize();
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

    public void testInOrder() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = scanner.nextInt();
            }

            TreeNode root = new TreeNode(array);
            root.printPreOrder();
            root.printInOrder();
            root.printPostOrder();
        }
    }

    public void testPriorityQueue(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(N, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) { //o2：parent  >0则break  默认是小顶堆o1.compareTo(o2)
                    return o2.compareTo(o1);
                }
            });
            for (int i = 0; i < N; i++) {
                maxHeap.offer(scanner.nextInt());
            }

            for (Integer i : maxHeap) {
                System.out.println(i);
            }
        }
    }

    public void testNumberOf1Between1AndN(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            System.out.println(new NumberOf1Between1AndN().numberOf1Between1AndN_Solution(N));
        }
    }

    public void testUglyNumber(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            System.out.println(new GetUglyNumber().getUglyNumber_Solution(N));
        }
    }

    public void testFirstNotRepeatingChar(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(new FirstNotRepeatingChar().firstNotRepeatingChar(str));
        }
    }

    public void testLastRemaining(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println(new LastRemaining().lastRemaining_Solution(n, m));
        }
    }

    public void testStr2Int(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(new StrToInt().strToInt(str));
        }
    }

    public void testIsNumeric(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(new IsNumeric().isNumeric(str.toCharArray()));
        }
    }
}
