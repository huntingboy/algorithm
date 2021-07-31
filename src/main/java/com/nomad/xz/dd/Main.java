package com.nomad.xz.dd;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().x2();
    }

    /**
     * D星群岛
     * 也可以转化为prim算法求最小生成树
     * 也可以dfs
     */
    class Node{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public void x2(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            Map<Integer, List<Node>> graph = new HashMap<>();
            for (int i1 = 0; i1 < m; i1++) {
                int x = sc.nextInt(), y = sc.nextInt(), cost = sc.nextInt();
                List<Node> nodes = graph.get(x);
                if (nodes == null) {
                    nodes = new ArrayList<>();
                }
                nodes.add(new Node(x, y, cost));
                graph.put(x, nodes);
            }

            Set<Integer> visited = new HashSet<>();
            int counts = 0;
            for (int j = 1; j <= n; j++) {
                if (!graph.containsKey(j)) {
                    continue;
                }
                List<Node> nodes = graph.get(j);
                boolean last = false;
                if (!visited.contains(j)) {
                    visited.add(j);
                    last = true;
                }
                for (Node node : nodes) {
                    if ((!visited.contains(node.y) || visited.contains(node.y) && last)&& node.cost <= k) {
                        visited.add(node.y);
                        counts++;
                    }
                }
            }

            if (counts == n - 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    /**
     * 破解X星人的密文
     */
    public void x1(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            int len = str.length();
            if (n >= len) {
                for (int i = len - 1; i >= 0; i--) {
                    System.out.print(str.charAt(i));
                }
            } else {
                int i = 0;
                while (i < len) {
                    String tmp = str.substring(i, Math.min(i + n, len));
                    for (int ii = tmp.length() - 1; ii >= 0; ii--) {
                        System.out.print(tmp.charAt(ii));
                    }
                    i += n;
                }
            }
            System.out.println();
        }
    }
}
