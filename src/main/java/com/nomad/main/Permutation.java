package com.nomad.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        dfs(a, 0);

        for (List<Integer> item : res) {
            System.out.println(item);
        }
    }

    private static void dfs(int[] a, int i) {
        if (i == a.length - 1) {
            List<Integer> path = new ArrayList<>();
            for (int ai : a) {
                path.add(ai);
            }
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < a.length; j++) {
            swap(a, i, j);
            dfs(a, i + 1);
            swap(a, i, j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}