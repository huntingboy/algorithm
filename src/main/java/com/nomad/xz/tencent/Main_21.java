package com.nomad.xz.tencent;

import java.util.*;

public class Main_21 {

    public static void main(String[] args) {
        new Main_21().sum();
    }

    public void x5(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

    }

    public void x4(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            List<Integer> nums1 = new ArrayList<>(nums);
            //Queue<Integer> queue = new PriorityQueue<>(n / 2, Comparator.reverseOrder());
            nums1.remove(i);
            Collections.sort(nums1);
            System.out.println(nums1.get((n - 1) / 2));
        }
    }

    class Item{
        String val;
        int counts;

        public Item(String key, Integer value) {
            this.val = key;
            this.counts = value;
        }

        @Override
        public String toString() {
            return val + " " + counts;
        }
    }
    public void x3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        Queue<Item> maxK = new PriorityQueue<>(k, (Comparator<Item>) (o1, o2) -> {
            if (o1.counts != o2.counts) {
                return o2.counts - o1.counts;
            } else {
                return o1.val.compareTo(o2.val);
            }
        }); //放出现次数最多的k个
        Queue<Item> minK = new PriorityQueue<>(k, (o1, o2) -> {
            if (o1.counts != o2.counts) {
                return o2.counts - o1.counts;
            } else {
                return o1.val.compareTo(o2.val);
            }
        });//放出现次数最少的K个  同上 堆顶放出现次数最多且字典序最小的item，只是堆满的时候入堆的规则不一样
        Map<String, Integer> str_counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            str_counts.put(str, str_counts.getOrDefault(str, 0) + 1);
        }

        int i = 0;
        for (Map.Entry<String, Integer> entry : str_counts.entrySet()) {
            Item item = new Item(entry.getKey(), entry.getValue());
            if (i < k) {
                minK.add(item);
                maxK.add(item);
                i++;
            } else {
                if (minK.peek().counts > item.counts || (minK.peek().counts == item.counts && minK.peek().val.compareTo(item.val) > 0)) {
                    minK.poll();
                    minK.add(item);
                } //次数小且字典序小才入堆
                if (maxK.peek().counts < item.counts || (maxK.peek().counts == item.counts && maxK.peek().val.compareTo(item.val) > 0)) {
                    maxK.poll();
                    maxK.add(item);
                } //次数大且字典序小才入堆
            }
        }

        int maxSize = maxK.size();
        for (int j = 0; j < maxSize; j++) {
            System.out.println(maxK.poll());
        }
        int minSize = minK.size();
        for (int j = 0; j < minSize; j++) {
            System.out.println(minK.poll());
        }
    }

    /**
     * 50 5
     * 2 1 2
     * 5 10 11 12 13 14
     * 2 0 1
     * 2 49 2
     * 4 6 7 8 2
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List[] nums = new ArrayList[m];
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int res = 1;
        Map<Integer, Integer> nid_qid = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            for (int i1 = 0; i1 < t; i1++) {
                int e = sc.nextInt();
                if (nums[i] == null) {
                    nums[i] = new ArrayList();
                }
                nums[i].add(e);
                nid_qid.put(e, i);
            }
        }

        stack.add(0);
        visited.add(0);
        while (!stack.isEmpty()) {
            int nid = stack.pop();
            int qid = nid_qid.get(nid);
            for (int i = 0; i < nums[qid].size(); i++) {
                if (!visited.contains(nums[qid].get(i))) {
                    res++;
                    stack.push((Integer) nums[qid].get(i));
                    visited.add((Integer) nums[qid].get(i));
                }
            }
        }

        System.out.println(res);
    }

    public void x1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int p = 0, q = 0;
        int[] res = new int[Math.min(m, n)];
        int i = 0;
        while (p < n && q < m) {
            if (a[p] < b[q]) {
                q++;
            } else if (a[p] > b[q]) {
                p++;
            } else {
                res[i] = a[p];
                i++;
                p++;
                q++;
            }
        }

        for (int j = 0; j < i; j++) {
            System.out.print(res[j]);
            if (j < i - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }


    /**
     * 最长回文串
     * dp[i][j]:[i,j]字符串最长回文串
     */
    public void huiwen() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            String sub = s.substring(l - 1, r);
            int min = sub.length();
            for (int j = 1; j <= sub.length(); j++) { //子串步长

            }

            System.out.println(min);
        }
    }

    boolean huiwen0(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }

        return s.charAt(0) == s.charAt(s.length() - 1) && huiwen0(s.substring(1, s.length() - 1));
    }

    /**
     * 刷板子最少次数
     */
    public void printBorad() { //同浇花题,找降序位置
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (i > 0 && a[i - 1] > a[i]) {
                if (flag) {
                    res += a[i - 1];
                    flag = false;
                } else {
                    //res =
                }

            }
        }

        System.out.println(res);
    }

    public void sum() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextInt();
            long max = 0;
            for (long j = 0; j <= n / 2; j++) {
                max = Math.max(max, sumL(j) + sumL(n - j));
            }

            System.out.println(max);
        }
    }

    private long sumL(long n) {
        long res = 0;
        while (n / 10 > 0) {
            res += n % 10;
            n /= 10;
        }
        res += n;

        return res;
    }

    /**
     * 从小到大第k个子串
     * 堆应该用PriorityQueue实现(底层也是数组,放满后会自动扩容)
     */
    public void kthSubStr() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        String[] res = new String[k + 1];

        int len = s.length(), size = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                size++;
                String tmp = s.substring(i, j);
                if (size <= k) {
                    res[size] = tmp;
                    if (size == k ) {
                        //调整最小堆
                        for (int l = k / 2; l >= 0; l--) {
                            int min = (res[l * 2].compareTo(res[l * 2] + 1) > 0) ? l * 2 + 1 : l * 2;
                            if (res[l].compareTo(res[min]) > 0) {
                                String tmp1 = res[l];
                                res[l] = res[min];
                                res[min] = tmp1;
                            }
                        }
                    }
                } else {

                }
            }
        }

        /*for (int i = 0; i < k; i++) {
            res.poll();
        }

        System.out.println(res.peek());*/
    }

    /**
     * 删除链表第k个节点
     */
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node deleteKthNode() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Node head = null, p = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (i == 0) {
                head = node;
                p = head;
            } else {
                if (i != m - 1) {
                    p.next = node;
                    p = node;
                }
            }
        }

        if (m == 1) {
            head = head.next;
        }
        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        return head;
    }
}
