package com.nomad.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, l=null, p = l;
        int tmp = 0;
        while (p1 != null && p2 != null) {
            ListNode node = new ListNode((p1.val + p2.val + tmp) % 10);
            tmp = (p1.val + p2.val + tmp) / 10;
            if (l == null) {
                l = node;
                p = l;
            } else {
                p.next = node;
                p = node;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            ListNode node = new ListNode((p1.val + tmp) % 10);
            tmp = (p1.val + tmp) / 10;
            p.next = node;
            p = node;
            p1 = p1.next;
        }
        while (p2 != null) {
            ListNode node = new ListNode((p2.val + tmp) % 10);
            tmp = (p2.val + tmp) / 10;
            p.next = node;
            p = node;
            p2 = p2.next;
        }
        if (tmp != 0) {
            ListNode node = new ListNode(tmp);
            p.next = node;
            p = node;
        }
        p.next = null;
        return l;
    }

    //三数之和 排序+双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length; i++) { //第一个数
            if (nums[i] > 0) { //不可能再有新的情况
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1]) {//跳过重复的情况
                continue;
            }

            int cur = nums[i];
            int L = i + 1, R = nums.length - 1; //双指针指向另外两个数
            while (L < R) {
                int tmp = cur + nums[L] + nums[R];
                if (tmp == 0) { //和为0的情况
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(list);//添加当前情况解
                    while (L < R && nums[L + 1] == nums[L]) {//跳过重复的情况
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {//跳过重复的情况
                        R--;
                    }
                    L++;
                    R--;
                } else if (tmp < 0) {//和小于0的情况
                    ++L;
                } else {//和大于0的情况
                    --R;
                }
            }
        }

        return res;
    }
}
