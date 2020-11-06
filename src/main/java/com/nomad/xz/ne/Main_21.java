package com.nomad.xz.ne;
import java.util.*;

public class Main_21 {
    public static void main(String[] args) {
        new Main_21().avg();
    }

    /**
     * 生成树(prim算法和krusta算法:基于Edge类,一维数组回路判断)中输出最大权值和最小权值差最小
     * todo
     */
    private void tree(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] w = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            w[sc.nextInt() - 1][sc.nextInt() - 1] = sc.nextInt();
        }

        //处理带平行边的无向图的情况 todo  w(复杂图)==>w1(多个简单图,遍历)
        //treeWithPrim(w1, n);
    }

    /**
     * prim算法
     * @param w       所有顶点间的距离
     * @param len     顶点个数
     */
    private void treeWithPrim(int[][] w, int len) {
        int[] lowcost = Arrays.copyOf(w[0], len); //已访问顶点(初始v0)到各个顶点的距离 0:已访问  Integer.MAX_VALUE:不可达
        int maxW = Integer.MIN_VALUE, minW = Integer.MAX_VALUE;

        for (int i = 0; i < len - 1; i++) {

            //找出距离已访问顶点集合最近的顶点
            int min = -1;
            for (int j = 0; j < len; j++) {
                if (lowcost[j] > 0) {
                    if (min == -1 || lowcost[min] > lowcost[j]) {
                        min = j;
                    }
                }
            }

            //判断距离是否全部为0，找不到最小值
            if (min == -1) {
                break;
            }

            //访问距离最短的一个顶点
            lowcost[min] = 0;
            minW = Math.min(minW, lowcost[min]);
            maxW = Math.max(maxW, lowcost[min]);

            //更新lowcost数组
            for (int j = 0; j < len; j++) {
                if (w[min][j] < lowcost[j]) {
                    lowcost[j] = w[min][j];
                }
            }
        }

        System.out.println(maxW - minW);
    }

    /**
     * 把物品分配给2人,使价值相等,输出最小扔掉的价值
     */
    private void avg(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n  = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[i] = sc.nextInt();
            }

            dfs(n, a, n - 1, 0, 0, 0);
            System.out.println(res);
        }
    }

    /**
     * 递归:a[i]分配到 p1,p2,value 3种情况考虑所有情况
     * @param n 当前价值数组长度
     * @param a 价值数组
     * @param i 当前位置
     * @param p1 第一个人得到的
     * @param p2 第二个人得到的
     * @param value 累计丢掉的
     * res 最少丢掉的价值数
     */
    private int res = Integer.MAX_VALUE;
    private void dfs(int n, int[] a, int i, int p1, int p2, int value) {
        if (i == -1) { //递归出口
            if (p1 == p2 && res > value) res = value; //更新res
            return;
        }

        dfs(n, a, i - 1, p1 + a[i], p2, value);//把a[i]给第一个人
        dfs(n, a, i - 1, p1, p2 + a[i], value);//把a[i]给第二个人
        dfs(n, a, i - 1, p1, p2, value + a[i]);//把a[i]丢弃
    }

    /**
     * 最小字典序列
     * fixme 0.3AC
     */
    private void seq(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[m];
        boolean[] a = new boolean[100001];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            a[nums[i]] = true;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < nums[i]; j++) {
                if (!a[j]) {
                    a[j] = true;
                    count++;
                    System.out.print(j + " ");
                }
            }
            count++;
            System.out.print(nums[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        for (int i = count + 1; i <= n; i++) {
            System.out.print(i);
            if (i < n) {
                System.out.print(" ");
            }
        }
    }

    private void seq2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < m; i++){
            int num = sc.nextInt();
            vis[num] = true;
            q.offer(num);
        }
        StringBuilder ans =new StringBuilder();
        for(int i = 1; i <= n; i++) { //以下5行为关键
            if(vis[i]) continue;
            while(!q.isEmpty() && q.peek() < i) ans.append(q.poll() + " ");
            ans.append(i + " ");
        }
        while(!q.isEmpty()) ans.append(q.poll() + " ");
        System.out.print(ans.toString().substring(0, ans.length() - 1));
    }

    /**
     * 每个数可拆分,输出最多的素数总个数
     */
    private void sushuCounts(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            res += a[i] / 2;
        }

        System.out.println(res);
    }

    /**
     * 按照个数排序
     */
    class Item implements Comparable<Item>{
        String val;
        int count;

        Item(){}
        Item(String val, int count){
            this.val = val;
            this.count = count;
        }

        public int compareTo(Item item){
            return this.count - item.count;
        }

        public String toString(){
            return val + " " + count;
        }
    }
    public void x1(){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> res = new HashMap<>();
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            res.put(str, res.getOrDefault(str, 0) + 1);
        }

        List<Item> items = new ArrayList<>();
        for(String key : res.keySet()){
            items.add(new Item(key, res.get(key)));
        }

        Collections.sort(items, Comparator.reverseOrder());
        Collections.sort(items, (o1, o2) -> o1.count - o2.count); //升序，item可以不用实现Comparable
        Collections.sort(items, Comparator.comparingInt(o -> o.count)); //同上
        Collections.sort(items, (o1, o2) -> o1.val.compareTo(o2.val));
        Collections.sort(items, Comparator.comparing(o -> o.val));
        Collections.sort(items, (o1, o2) -> o2.count - o1.count);//降序，item可以不用实现Comparable
        Collections.sort(items, Comparator.reverseOrder()); //降序，item必须实现Comparable

        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i));
        }
    }
}
