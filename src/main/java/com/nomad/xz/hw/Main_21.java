package com.nomad.xz.hw;

import java.util.Arrays;

/**
 * 华为
 */
public class Main_21 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 1, 0, 1, 1, 0, 0, 1
        };
        int cycleNums = 7;
        for (int i = 0; i <= cycleNums; i++) {
            int[] res = x2(nums, i);
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[j]);
                if (j < res.length - 1) {
                    System.out.print(" ");
                }else
                    System.out.println();
            }
        }
    }

    //x1 : 找[a,b]最高最低的树的高度差，注意判断数据的合法性

    /**
     * 0 1 0 1 1 0 0 1     7
     * 0 0 1 1 0 0 0 0
     *
     *
     *
     * 0 : 0 1 0 1 1 0 0 1
     * 1 : 0 1 1 0 0 0 0 0
     *     0 0 0 0 1 1 1 0
     *     0 1 1 0 0 1 0 0
     *     0 0 0 0 0 1 0 0
     *     0 1 1 1 0 1 0 0
     *     0 0 1 0 1 1 0 0
     *     0 0 1 1 0 0 0 0
     *
     * 1 0 0 1 0 0 1 0   10000000000
     * 0 0 1 1 1 1 1 0
     */
    public static int[] x2(int[] nums, int cycleNums) {
        int[] res = Arrays.copyOf(nums, nums.length);
        int len = nums.length;
        for (int i = 0; i < cycleNums; i++) {
            nums = Arrays.copyOf(res, len);
            if (i == 0) {
                res[0] = 0;
                res[len - 1] = 0;
            }
            for (int j = 1; j < len - 1; j++) {
                if (nums[j - 1] == nums[j + 1]) {
                    res[j] = 1;
                } else {
                    res[j] = 0;
                }
            }
        }

        return res;
    }
}
