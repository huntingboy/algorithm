package com.nomad.xz.hs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 恒生
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x2();
    }

    /**
     * 完美洗牌问题
     */
    public void x3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        for (int i = 1; i < n - 1; i += 2) {
            int tmp = nums[i];
            nums[i]  = nums[i + 1];
            nums[i + 1] = tmp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }else
                System.out.println();
        }
    }

    /**
     * 不算分，跳过
     * 重复元素
     * 后来补考换为斐波拉契数列和atoi
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            atoi(str);
        }
    }

    public void atoi(String str) {
        try {
//            long tmp = Long.parseLong(str);
            double tmp = Double.parseDouble(str);
            if (tmp > Integer.MAX_VALUE) {
                System.out.println(Integer.MAX_VALUE);
            } else if (tmp < Integer.MIN_VALUE) {
                System.out.println(Integer.MIN_VALUE);
            } else {
                System.out.println((int)tmp);
            }
        } catch (Exception e) {
            System.out.println(0);
        }
    }

    /**
     * 做项目的最大收益问题
     */
    class Item implements Comparable<Item>{
        int c;
        int p;

        public Item() {
        }

        public Item(int c, int p) {
            this.c = c;
            this.p = p;
        }

        public Item(int c) {
            this.c = c;
        }

        @Override
        public int compareTo(Item o) {
            return this.c - o.c;
        }
    }
    int max = 0;
    public void x1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt(), k = sc.nextInt();
        Item[] c_p = new Item[n];
        for (int i = 0; i < n; i++) {
            c_p[i] = new Item(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            c_p[i].p = sc.nextInt();
        }

        Arrays.sort(c_p);

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            x10(c_p, i, visited, w, k);
        }

        System.out.println(max);
    }

    private void x10(Item[] c_p, int i, boolean[] visited, int w, int k) {
        if (k == 0) {
            max = Math.max(max, w);
            return;
        }

        for (int j = i; j < c_p.length; j++) {
            visited[i] = true;
            if (w >= c_p[j].c) {
                x10(c_p, j, visited, w + c_p[j].p, k - 1);
            }else
                break;
            visited[i] = false;
        }
    }

    /**
     * 不超时
     * 2个贪心的优先队列
     * 同一个item存了2份
     */
    public void xx1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt(), k = sc.nextInt();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }
        int[] profiles = new int[n];
        for (int i = 0; i < n; i++) {
            profiles[i] = sc.nextInt();
        }

        Queue<int[]> cost = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]); //花费升序，最小堆
        Queue<int[]> profile = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]); //利润降序，最大堆

        for (int i = 0; i < n; i++) {
            cost.offer(new int[]{costs[i], profiles[i]});
        }
        while (k != 0) {
            while (!cost.isEmpty() && w >= cost.peek()[0]) {
                profile.offer(cost.poll());
            }
            if (profile.isEmpty()) {
                break;
            }
            w += profile.poll()[1];
            k--;
        }

        System.out.println(w);
    }
}
