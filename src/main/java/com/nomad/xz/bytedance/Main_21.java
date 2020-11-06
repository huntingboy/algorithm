package com.nomad.xz.bytedance;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_21 {
    //链表的深拷贝 -> 图的深度优先遍历 map存放已clone节点
    //123456789101112第m个数 一位数:10个字符 二位数:2*90个 三位数:3*900个  m->具体的区间->区间中的第几个
    //普通单链表翻转


    /**
     * n个cpu调度m个任务
     * 1.空闲的cpu，取最小的cpu id执行任务
     * 2.没有空闲的cpu，任务等待，第一个完成任务且cpu id最小的cpu执行该任务
     *
     * 3(n) 7(m)
     * 2(任务提交时间) 8(任务执行时间)
     * 3 4
     * 4 3
     * 6 1
     * 7 1
     * 8 3
     * 10 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Queue<Item> runnings = new PriorityQueue<>();
        boolean[] used = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            Item item = new Item(sc.nextInt(), sc.nextInt());
            if (i <= n) {
                System.out.println(i);
                used[i] = true;
                item.setZ(i);
                runnings.offer(item);
            } else {
                while (runnings.size() > 0 && item.x >= runnings.peek().x + runnings.peek().y) {//移除已经完成的任务
                    Item finished = runnings.poll();
                    used[finished.z] = false;
                }

                if (runnings.size() < n) {//有空闲的cpu，找id最小的分配任务
                    int j = 1;
                    for (; j < used.length; j++) {
                        if (!used[j]) {
                            break;
                        }
                    }
                    System.out.println(j);
                    used[j] = true;
                    item.setZ(j);
                    runnings.offer(item);
                } else { //等待最先完成的cpu运行此次任务
                    Item finished = runnings.poll();
                    //used[finished.z] = true;
                    System.out.println(finished.z);
                    item.setZ(finished.z);
                    item.setX(finished.x + finished.y);
                    runnings.offer(item);
                }
            }
        }
    }
    static class Item implements Comparable<Item>{
        int x; //任务开始时间 ，不一定等于输入时的值（任务提交时间）
        int y; //任务结束时间
        int z; //任务运行所在cpu的id

        public Item() {
        }

        public Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Item(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

        @Override
        public int compareTo(Item o) {//完成时间晚，cpu id大的放在优先级队列后面
            int sl = x + y;
            int sr = o.x + o.y;
            if (sl != sr) {
                return sl - sr;
            }
            return z - o.z;
        }
    }

}
