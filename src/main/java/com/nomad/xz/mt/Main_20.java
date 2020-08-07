package com.nomad.xz.mt;

import java.util.Arrays;

/**
 * @author nomad
 * @create 2020-07-16 11:19 AM
 */
public class Main_20 {

    public static void main(String[] args) {
        //TestStatic.getInstance();
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }*/
        /*int[][] array = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = scanner.nextInt();
            }
        }*/

        //System.out.println(new Main_20().discount(array, x));
    }

    //外卖满减
    private int discount(int[] price, int x) {
        int res = 0;
        Arrays.sort(price);


        return res;
    }

    //种花  数组 贪心算法(每天的跨度尽量大，每次找最小的数并从周围连续的数中减去该值)  超时
    private int platFlower(int[] flowers) {
        int len = flowers.length, res = 0, minIdx = 0;
        while (true) {
            boolean first = true; //是否是第一个大于0的数
            //找最小的正数下标
            for (int i = 0; i < len; i++) {
                if (flowers[i] > 0) {
                    if (first) {
                        minIdx = i;
                        first = false;
                    } else if (flowers[minIdx] > flowers[i]) {
                        minIdx = i;
                    }
                }
            }
            if (first) {
                break;
            } else {
                int l = minIdx - 1, r = minIdx + 1;
                res += flowers[minIdx];
                while (l >= 0 && flowers[l] > 0) {
                    flowers[l] -= flowers[minIdx];
                    l--;
                }
                while (r < len && flowers[r] > 0) {
                    flowers[r] -= flowers[minIdx];
                    r++;
                }
                flowers[minIdx] = 0;
            }
        }

        return res;
    }

    //种花  找降序位置，累加进结果
    private int platFlower2(int[] flowers) {
        int len = flowers.length, res = 0;
        for (int i = 1; i < len; i++) {
            if (flowers[i - 1] <= flowers[i]) {
                continue;
            }
            res += flowers[i - 1] - flowers[i];
        }
        res += flowers[len - 1];

        return res;
    }

    //考试策略  0/1背包问题  动态规划自底向上
    private int examStratage(int[][] time_score) {
        int[] res = new int[121];
        int n = time_score.length;
        for (int i = 0; i < n; i++) {
            for (int j = res.length - 1; j >= 0; j--) {
                if (j >= time_score[i][0]) {
                    res[j] = Math.max(res[j], res[j - time_score[i][0]] + time_score[i][1]);
                }
                if (j >= time_score[i][2]) {
                    res[j] = Math.max(res[j], res[j - time_score[i][2]] + time_score[i][3]);
                }
            }
        }

        return res[120];
    }
}
