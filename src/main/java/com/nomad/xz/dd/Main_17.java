package com.nomad.xz.dd;

import java.util.*;

/**
 * @author nomad
 * @create 2020-08-13 6:23 PM
 */
public class Main_17 {
    public static void main(String[] args) {
        new Main_17().sumCountDP();
    }

    /**
     * 数字和为sum的方法数
     * 0/1背包 动态规划 二维dp优化为一维dp
     * dp[j]:和为j的方案个数
     */
    public void sumCountDPOptimize(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = sc.nextInt();
        int[] nums = new int[n];
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {//依次加数，前i个数
            nums[i] = sc.nextInt();
            for (int j = sum; j >= nums[i]; j--) { //一定是从右往左遍历更新dp，因为01背包每个数只能取一次，若从左往右更新，则会重复取nums[i]
                dp[j] += dp[j - nums[i]];
            }
        }
        sc.close();

        System.out.println(dp[sum]);
    } 

    /**
     * 数字和为sum的方法数
     * 动态规划 dp[i][j]:前i个数和为j的方案个数
     * dp[i][j]=dp[i-1][j] + dp[i-1][j-nums[i]]
     */
    public void sumCountDP(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        long[][] dp = new long[n + 1][sum + 1]; //n+1和sum+1，加了一个纵横边界[i][0]和[0][j]
        //初始化二位数组dp边界
        //dp[i][0]:前i个数组成和为0的个数
        //dp[0][j]:取0个数和为j的个数
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i-1] <= j) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                else dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][sum]);
    }

    /**
     * 数字和为sum的方法数
     * 回溯 超时 0.5ac
     */
    private int ret = 0;
    private int sum;
    public void sumCount(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sum = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(nums); //排序前后递归都超时
        for (int i = 0; i < n; i++) {
            if (nums[i] > sum) break;
            sumCount0(nums, i, nums[i]);
        }

        System.out.println(ret);
    }

    private void sumCount0(int[] nums, int start, int curSum) {
        if (curSum == sum) {
            ret++;
            return;
        }

        for (int i = start + 1; i < nums.length; i++) {
            if (curSum + nums[i] > sum) break;
            sumCount0(nums, i, curSum + nums[i]);
        }
    }

    /**
     * 进制转换
     * 递归或者栈
     */
    public void dec2N(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.close();

        boolean positive = (m < 0) ? false : true;
        m = Math.abs(m);
        if (!positive) {
            System.out.print("-");
        }
        dec2N0(m, n);
        /*Stack<Integer> res = new Stack<>();
        while (m > 0) {

        }

        if (res.empty()) {
            System.out.println(0);
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.pop());
            }
        }*/
    }

    private void dec2N0(int m, int n) {
        if (m < n) {
            printN(m);
            return;
        }

        dec2N0(m / n, n);
        printN(m % n);
    }

    private void printN(int m) {
        if (m < 10) {
            System.out.print(m);
        } else {
            System.out.print((char)('A' + m - 10));
        }
    }

    /**
     * 末尾0的个数
     * 要相乘产生0，那肯定是与5相乘的结果
     * 对n!如果分解质因数的话，结果为0的个数只与2与5的个数有关，每一次2*5就能产生一个0
     * 因为2的个数肯定要大于5的个数，所以只要关注5的个数就可以了
     * 不需要对<=n的每个数分解质因子计算，只需要计算5的倍数累加
     */
    public void countZero(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }

        System.out.println(res);
    }

    /**
     * 地下迷宫
     */
    private class Axis {
        private int x;
        private int y;

        public Axis() {
        }

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }

    private int minCost = Integer.MAX_VALUE, p;
    private List<Axis> res = new ArrayList<>();

    public void maze(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        p = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        sc.close();

        List<Axis> path = new ArrayList<>();
        maze0(nums, 0, 0, path, 0);

        if (res.isEmpty()) {
            System.out.println("Can not escape!");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i < res.size() - 1) System.out.print(",");
            }
            System.out.println();
        }
    }

    private void maze0(int[][] nums, int i, int j, List<Axis> path, int cost) {
        //出口
        if (i == 0 && j == nums[0].length - 1) {
            if (cost < minCost) {
                minCost = cost;
                Axis axis = new Axis(i, j);
                path.add(axis);
                res = new ArrayList<>(path);
                path.remove(path.size() - 1);
            }
            return;
        }

        nums[i][j] = 0;
        Axis axis = new Axis(i, j);
        path.add(axis);
        //向上走
        if (i > 0 && nums[i - 1][j] == 1 && cost + 3 <= p && cost + 3 < minCost) maze0(nums, i - 1, j, path, cost + 3);
        //向下走
        if (i < nums.length - 1 && nums[i + 1][j] == 1) maze0(nums, i + 1, j, path, cost);
        //向左走
        if (j > 0 && nums[i][j - 1] == 1 && cost + 1 <= p && cost + 1 < minCost) maze0(nums, i, j - 1, path, cost + 1);
        //向右走
        if (j < nums[0].length - 1 && nums[i][j + 1] == 1 && cost + 1 <= p && cost + 1 < minCost) maze0(nums, i, j + 1, path, cost + 1);
        nums[i][j] = 1;
        path.remove(path.size() - 1);
    }


    /**
     * 餐馆
     */
    private class Desk implements Comparable<Desk> {
        private int head;
        private int cost;

        public Desk() {
        }

        public Desk(int head, int cost) {
            this.head = head;
            this.cost = cost;
        }

        @Override
        public int compareTo(Desk o) {
            return cost - o.cost;
        }
    }
    public void restaurant(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] cap = new int[n];
        Desk[] desks = new Desk[m];
        for (int i = 0; i < n; i++) {
            cap[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            desks[i] = new Desk(sc.nextInt(), sc.nextInt());
        }
        sc.close();

        Arrays.sort(cap); //桌子容量要升序排序
        Arrays.sort(desks, Comparator.reverseOrder()); //按照消费排序后贪心安排桌子
        long res = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < m; i++) {
            if (desks[i].head > cap[n - 1]) continue;
            int l = 0, r = n - 1, mid = 0;
            while (l <= r) { //二分查找找第一个容的下的桌子, 如果顺序查找超时
                mid = (l + r) >> 1;
                if (cap[mid] >= desks[i].head) r = mid - 1;
                else l = mid + 1;
            }
            while (l < n && used[l]) l++; //跳过已使用过的桌子
            if (l < n) {
                used[l] = true;
                res += desks[i].cost;
            }
        }

        System.out.println(res);
    }

    /**
     * 连续最大和
     */
    public void sum(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        long res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(res);
    }
}
