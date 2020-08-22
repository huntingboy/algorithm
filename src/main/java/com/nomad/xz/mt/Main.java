package com.nomad.xz.mt;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().areaMeeting();
    }

    /**
     * 小美的AB队
     * 回溯或动态规划
     */
    List<String> res = new ArrayList<>();
    public void ABQueue() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean[] flag = new boolean[m + n]; //true表示A队
        for (int i = 0; i < n + m; i++) {
            flag[i] = true;
            //ABQueue0(nums, 0, path, sum);
            flag[i] = false;
        }

    }

    /**
     * 小美的会议区域参与人选取方案数
     */
    private class Node {
        int id;
        int level;
        List<Node> childs = new LinkedList<>();
    }
    public void areaMeeting() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n - 1; i++) {
            Node node = new Node();
            node.id = sc.nextInt();
            Node node1 = new Node();
            node1.id = sc.nextInt();
            node.childs.add(node1);
            nodes[node.id] = node;
            nodes[node1.id] = node1;
        }
        for (int i = 0; i < n; i++) {
            nodes[i].level = sc.nextInt();
        }


    }

    /**
     * 小美的仓库管理
     * 0.18ac
     */
    public void repoManage(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        int l = 0, r = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            int t = w[idx - 1];
            w[idx - 1] = 0;
            if (i == 0) {
                l = sum(w, 0, idx - 1);
                r = sum(w, idx, n);
            } else if (pre < idx) {
                r -= t;
                int tmp = sum(w, pre, idx - 1);
                l += tmp;
                r -= tmp;
            } else {
                l -= t;
                int tmp = sum(w, idx, pre - 1);
                l -= tmp;
                r += tmp;
            }
            pre = idx;
            //System.out.println(Math.max(sum(w, 0, idx - 1), sum(w, idx, n)));
            System.out.println(Math.max(l, r));
        }

    }

    private int sum(int[] w, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res += w[i];
        }

        return res;
    }

    /**
     * 小美的代购产品
     * todo 用堆排序  top m
     * 0.18ac
     */
    private class Item implements Comparable<Item>{
        int x;
        int y;
        int sum;
        int idx;

        public Item(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.sum = x + y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Item o) {
            if (sum > o.sum) return 1;
            if (sum == o.sum) {
                if (x > o.x) return -1;
                else
                    return y >= o.y ? -1 : 1;
            }

            return -1;
        }
    }

    public void proxyBuy() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Item[] res = new Item[n];
        for (int i = 0; i < n; i++) {
            res[i] = new Item(sc.nextInt(), sc.nextInt(), i + 1);
        }

        Arrays.sort(res, Comparator.reverseOrder());
        for (int i = 0; i < m; i++) {
            System.out.print(res[i].idx);
            if (i < m - 1) System.out.print(" ");
            else
                System.out.println();
        }
    }

    /**
     * 小美的校验用户名程序
     * ac
     */
    public void validateUsername() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String username = sc.next();
            boolean res = false;
            if (username != null && username.length() > 1) {
                char start = username.charAt(0);
                if (isLetter(start)) {
                    boolean hasNumber = false;
                    int j = 1;
                    for (; j < username.length(); j++) {
                        char ch = username.charAt(j);
                        if (!isLetter(ch) && !Character.isDigit(ch)) {
                            break;
                        }
                        if (Character.isDigit(ch)) {
                            hasNumber = true;
                        }
                    }
                    if (hasNumber && j == username.length()) {
                        res = true;
                    }
                }
            }

            if (res) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }
        sc.close();
    }

    private boolean isLetter(char start) {
        return (start >= 'a' && start <= 'z') || (start >= 'A' && start <= 'Z');
    }
}
