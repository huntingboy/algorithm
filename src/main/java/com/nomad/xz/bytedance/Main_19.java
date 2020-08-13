package com.nomad.xz.bytedance;

import java.util.*;

/**
 * @author nomad
 * @create 2020-08-10 12:10 AM
 */
public class Main_19 {
    public static void main(String[] args) {
        new Main_19().jump();
    }

    /**
     * 机器人跳跃问题
     * e(k)+e(k)-H(k+1)=e(k+1)
     * e(k)=(ek+1)+H(k+1))/2
     * 这是临界条件，要用浮点数,完了向上取整
     */
    public void jump(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        sc.close();

        double res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res = (res + h[i]) / 2;
        }

        System.out.println((int) Math.ceil(res));
    }

    /**
     * 找零
     * 贪心或者dp
     */
    public void charge(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res = 0;
        int[] value = new int[]{1, 4, 16, 64};
        n = 1024 - n;
        for (int i = 3; i >= 0; i--) {
            while (n / value[i] != 0) {
                res += n / value[i];
                n = n % value[i];
            }
        }

        System.out.println(res);
    }

    /**
     * 毕业旅行问题
     * 动态规划  位运算
     * e.g. n = 4的情况:
     * dp(0,{1,2,3})=min({C01 + dp(1, {2,3}}, {C02 + dp(2, {1,3})}, {C03 + dp(3, {1,2})})
     * Cik:dist[i][k]
     * d(k, {}) = dist[0][k]
     */
    public void travel() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        int V = 1 << n - 1; //除0外的n-1个数集合的子集个数为2^(n-1)
        int[][] dp = new int[n][V];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dist[i][0];
        }

        for (int j = 1; j < V; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (((j >> (i - 1)) & 1) == 0) { //((j >> (i - 1))是把第i号城市取出来  位与上1，等于0，说明是从i号城市出发，经过城市子集V[j]，回到起点0号城市
                    for (int k = 0; k < n; k++) {
                        if (((j >> (k - 1)) & 1) == 1) { //遍历城市子集V[j], k为该集合中的每个元素
                            dp[i][j] = Math.min(dp[i][j], dist[i][k] + dp[k][j ^ (1 << (k - 1))]); //dp[k][j ^ (1 << (k - 1))，是将dp定位到，从k城市出发，经过城市子集V[s]，回到0号城市所花费的最小距离
                        }
                    }

                }
            }
        }

        System.out.println(dp[0][V - 1]);
    }

    /**
     * 特征提取
     * 双map
     */
    public void feature(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n = sc.nextInt();
        for (int i = 0; i < t; i++) { //测试用例数
            Map<String, Integer> counts = new HashMap<>(); //key:"x y"  value:最近特征连续出现次数
            Map<String, Integer> counts1 = new HashMap<>(); //同上  辅助实现重置，保证连续有效
            int res = 0;
            for (int j = 0; j < n; j++) { //特征行数
                int m = sc.nextInt();
                counts1.clear();
                for (int k = 0; k < m; k++) { //特征数
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    String key = "" + x + " " + y;
                    int count = counts.getOrDefault(key, 0) + 1;
                    counts1.put(key, count);
                    res = Math.max(count, res);
                }
                counts.clear();
                counts.putAll(counts1);
            }

            System.out.println(res);
        }
    }


    /**
     * 雀魂启动
     * 回溯递归
     */
    private List<Integer> res = new ArrayList<>();
    public void sparrow(){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 13; i++) {
            nums[sc.nextInt()]++;
        }
        sc.close();

        for (int i = 1; i < 10; i++) {
            if (nums[i] == 0) continue; //i不能当做雀头
            else if (nums[i] == 1) { //加一个牌i当做雀头
                nums[i]--;
                if (sparrow0(nums)) res.add(i);
                nums[i]++;
            } else { //取两个i当做雀头
                nums[i] -= 2;
                for (int j = 1; j < 10; j++) {
                    if (i == j && nums[i] == 2 || nums[j] == 4) continue; //nums[i]初始值为4
                    else {
                        nums[j]++;
                        if (sparrow0(nums)) res.add(j);
                        nums[j]--;
                    }
                }
                nums[i] += 2;
            }
        }

        if (res.isEmpty()) {
            System.out.println(0);
        } else {
            Collections.sort(res);
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.print(res.get(res.size() - 1));
        }
    }

    private boolean sparrow0(int[] nums) {
        int i = 0;
        boolean flag = true; //是否还有牌
        for (; i < nums.length; i++) {
            if (nums[i] > 2) { //刻子
                flag = false;
                nums[i] -= 3;
                boolean tmp = sparrow0(nums);
                nums[i] += 3;
                return tmp;
            } else if (nums[i] > 0) {
                flag = false;
                if (i + 2 < nums.length && nums[i + 1] > 0 && nums[i + 2] > 0) { //顺子
                    nums[i]--;
                    nums[i + 1]--;
                    nums[i + 2]--;
                    boolean tmp = sparrow0(nums);
                    nums[i]++;
                    nums[i + 1]++;
                    nums[i + 2]++;
                    return tmp;
                } else
                    break;
            }
        }

        return flag;
    }


    /**
     * 万万没想到之抓捕孔连顺
     *
     */
    public void arrest() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        long res = 0;
        if (n > 2) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            sc.close();

            int l = 0, r = 2; //窗口左右边界
            while (r < n) {
                if (nums[r] - nums[l] > d) l++;
                else if (r - l < 2) r++;
                else { //每次固定选中r指向的数，从前面选出2个数
                    int num = r - l;
                    res += (long) num * (num - 1) / 2;
                    r++;
                }
            }
            res %= 99997867;
        }

        System.out.println(res);
    }

    /**
     * 万万没想到之聪明的编辑
     */
    public void editor(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String w = sc.next();
            for (int j = 0; j < w.length(); j++) {
                if (j + 2 < w.length() && w.charAt(j + 1) == w.charAt(j)) {
                    while (j + 2 < w.length() && w.charAt(j + 1) == w.charAt(j + 2)) { //AAA情况==>AA
                        j++;
                    }
                    sb.append(w.substring(j, j + 2));
                    j += 2;

                    while (j + 1 < w.length() && w.charAt(j) == w.charAt(j + 1)) { //AABB情况==>AAB
                        j++;
                    }
                    if(j < w.length()) sb.append(w.charAt(j));
                } else {
                    sb.append(w.charAt(j));
                }
            }
            System.out.println(sb);
        }
    }
}
