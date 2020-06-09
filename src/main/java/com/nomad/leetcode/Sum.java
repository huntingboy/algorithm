package com.nomad.leetcode;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int t = scanner.nextInt();
            a = new Sum().twoSum(a, t);
            System.out.println("" + a[0] + ":" + a[1]);
        }
    }

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) return null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}
