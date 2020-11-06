package com.nomad.xz.sg;

import java.util.*;

/**
 * 搜狗
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main_21 {
    public static void main(String[] args) {
        Interval tmp = new Main_21().trim(3, 4, new Interval[]{
                new Interval(0, 1),
                new Interval(0, 2),
                new Interval(2, -1),
                new Interval(2, 1),
        });
        System.out.println(tmp.start + ":" + tmp.end);
    }

    /**
     * 词网简化
     * int[] c ,从起点广度优先走一趟，c[i]++；从终点反着走一趟,c[i]++,统计2的个数
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 在Interval类中返回结果，其中start表示有效字的个数，end表示全部有效字编号的和除以100000007的余数。
     * @param N int整型 字的总数
     * @param M int整型 连接关系的总数
     * @param conn Interval类一维数组 全部连接关系
     * @return Interval类
     */
    Set<Integer> ids = new HashSet<>();
    public static final int MOD = (int) (1e8+7);
    public Interval trim (int N, int M, Interval[] conn) {
        // write code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (Interval interval : conn) {
            List<Integer> next = graph.getOrDefault(interval.start, new ArrayList<>());
            next.add(interval.end);
            graph.put(interval.start, next);
        }

        dfs(graph, 0, new ArrayList<Integer>());
        int count = ids.size(), sum = 0;
        for (Integer id : ids) {
            sum = (sum + id) % MOD;
        }

        return new Interval(count - 1, sum);
    }

    private void dfs(Map<Integer, List<Integer>> graph, int i, List<Integer> path) {
        if (i == -1) {
            for (Integer id : path) {
                ids.add(id);
            }
            return;
        }

        path.add(i);
        List<Integer> next = graph.get(i);
        if (next != null) {
            for (Integer id : next) {
                dfs(graph, id, path);
            }
        }
        path.remove(path.size() - 1);
    }

    /**
     * 旋转密码
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public String rotatePassword (String[] s1, String[] s2) {
        // write code here
        StringBuilder sb = new StringBuilder();
        char[][] nums = string2array(s1);
        char[][] chars = string2array(s2);
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                nums = rotate(nums);
            }
            for (int j = 0; j < s1.length; j++) {
                for (int k = 0; k < s1.length; k++) {
                    if (nums[j][k] == '0') {
                        sb.append(chars[j][k]);
                    }
                }
            }
        }

        return sb.toString();
    }

    private char[][] rotate(char[][] nums) {
        char[][] res = new char[nums.length][nums.length];
        for (int j = 0; j < nums.length; j++) {
            for (int i = nums.length - 1; i >= 0; i--) {
                res[j][nums.length - i - 1] = nums[i][j];
            }
        }

        return res;
    }

    private char[][] string2array(String[] s) {
        char[][] res = new char[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                res[i][j] = s[i].charAt(j);
            }
        }

        return res;
    }

    /**
     * 做对的题数
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     *
     * @param n    int整型 选择题总数
     * @param k    int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public Interval solve(int n, int k, String str1, String str2) {
        // write code here
        Interval res = new Interval(0, 0);
        if (str1.equals(str2)) {
            res.start = k;
            res.end = k;
            return res;
        }

        int same = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                same++;
            }
        }
        res.start = Math.max(k - (n - same), 0);
        res.end = Math.min(k, same) + n - Math.max(k, same);

        return res;
    }
}
