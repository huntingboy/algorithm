package com.nomad.xz.zy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 招银网络科技
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x1();
    }

    /**
     * 出栈的所有可能序列
     */
    List<List<Integer>> res = new ArrayList<>();
    public void x1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> item = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(nums, 0, stack, item);
    }

    private void dfs(int[] nums, int i, Stack<Integer> stack, List<Integer> item) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }


    }
}
