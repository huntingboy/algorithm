package com.nomad.xz.ne;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nomad
 * @create 2020-08-08 12:32 AM
 */
public class Main_19 {
    public static void main(String[] args) {
        new Main_19().buyHouse();
    }

    /**
     * 香槟塔
     */
    public void tower() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] cap = new int[n];
        for (int i = 0; i < n; i++) {
            cap[i] = sc.nextInt();
        }
        int[] full = Arrays.copyOf(cap, n);
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int i1 = sc.nextInt() - 1;
                System.out.println(full[i1] - cap[i1]);
            } else {
                int x = sc.nextInt(), v = sc.nextInt();
                for (int j = x - 1; j < n; j++) {
                    if (cap[j] >= v) {
                        cap[j] -= v;
                        break;
                    } else {
                        v -= cap[j];
                        cap[j] = 0;
                    }
                }
            }
        }
    }
    
    /**
     *买房
     */
    public void buyHouse(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), k = sc.nextInt(), res = 0;
            if (n > 2 && k > 1) {
                res = Math.min(n - k, k - 1); //剩余房子很少或剩余房子很多
            }
            System.out.println("0 " + res);
        }
    } 
    
    /**
     * 翻转翻转
     */
    public void rotate(){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long A1=scanner.nextLong();
            long A2=scanner.nextLong();
            long s;
            if(A1==1&&A2==1){
                s=1;
            }else if(A1==1){
                s=A2-2;
            }else if(A2==1){
                s=A1-2;
            }else{
                s=(A1-2)*(A2-2);
            }
            System.out.println(s);
        }
    }

    /**
     * 代价  3个数的最小间距和
     */
    public void cost(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int delta1 = Math.abs(a - b), delta2 = Math.abs(a - c),  delta3 = Math.abs(b - c), res = 0;
        if (delta1 < delta2) {
            if (delta2 < delta3) {
                res = delta1 + delta2;
            } else {
                res = delta1 + delta3;
            }
        } else {
            if (delta1 < delta3) {
                res = delta2 + delta1;
            } else {
                res = delta2 + delta3;
            }
        }

        System.out.println(res);
    }

    /**
     * 访友
     */
    public void visit(){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        System.out.println((int)Math.ceil(x / 5.0));
    }
}
