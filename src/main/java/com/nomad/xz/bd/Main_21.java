package com.nomad.xz.bd;

import java.util.*;

/**
 * 百度
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x1();
    }

    /**
     * 排队吃饭
     */
    public void x3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        double res = 0;
        int[] nums = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        res = m * n / sum;
        System.out.println(res);
    }

    /**
     * 排队
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, Integer> id_zid = new HashMap<>();
        Vector<Integer>[] ids = new Vector[n + 1];
        for (int i = 1; i <= n; i++) {
            id_zid.put(i, i);
            if (ids[i] == null) {
                ids[i] = new Vector<>();
            }
            ids[i].add(i);
        }
        for (int i = 0; i < m; i++) {
            char command = sc.next().charAt(0);
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (command == 'C') {
                int size = ids[a].size();
                for (int j = 0; j < size; j++) {
                    int tid = ids[a].get(j);
                    id_zid.put(tid, b);
                    ids[b].add(tid);
                }
                ids[a].clear();
            } else if (command == 'Q') {
                if (id_zid.get(a).equals(id_zid.get(b))) {
                    int zid = id_zid.get(a);
                    int ai = ids[zid].indexOf(a);
                    int bi = ids[zid].indexOf(b);
                    System.out.println(Math.abs(ai - bi - 1));
                } else {
                    System.out.println(-1);
                }
            }

        }
    }

    /**
     * 选角色
     */
    public void x1(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                b[j] = sc.nextInt();
            }

            for (int j = 0; j < n; j++) {
                System.out.println((n - j - 1));
            }
        }
    }
}
