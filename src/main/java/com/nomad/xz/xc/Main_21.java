package com.nomad.xz.xc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 携程
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x3();
    }

    /**
     * 二维空间探险
     */
    int res = Integer.MAX_VALUE;
    int[][] directions = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0,1}
    };
    public void x3(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), e0 = sc.nextInt(), x = sc.nextInt(), l = sc.nextInt();
        int[][] nums = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               nums[i][j] = sc.nextInt();
            }
        }

        x30(nums, 0, 0, e0, 0, x, l, visited);

        System.out.println(res);
    }

    private void x30(int[][] nums, int i, int j, int e0, int len, int x, int l, boolean[][] visited) {
        if (i == nums.length - 1 && j == nums[0].length - 1) {
            res = Math.min(res, len);
            return;
        }

        if (i != 0 || j != 0) {
            e0 -= nums[i][j];
        }
        len++;
        visited[i][j] = true;
        for (int k = 0; k < directions.length; k++) {
            int i1 = directions[k][0] + i;
            int j1 = directions[k][1] + j;
            if (i1 < 0 || i1 >= nums.length || j1 < 0 || j1 >= nums[0].length) {
                continue;
            }
            if (visited[i1][j1]) {
                continue;
            }
            if (x <= 0 && nums[i1][j1] > e0) {
                continue;
            } else if (x <= 0) {
                x30(nums, i1, j1, e0, len, x, l, visited);
            } else {
                if (nums[i1][j1] <= e0) {
                    x30(nums, i1, j1, e0, len, x, l, visited);
                } else if (l >= nums[i1][j1]) {
                    x30(nums, i1, j1, l, len, x - 1, l, visited);
                }
            }
        }
    }

    /**
     * 订单系统工作流路径解析
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        StringBuilder[] res = new StringBuilder[100];
        while (sc.hasNext()) {
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {

            }
        }
    }

    /**
     * 敏感词替换
     */
    public void x1(){
        Scanner sc = new Scanner(System.in);
        String sen_word = sc.nextLine();
        String sentence = sc.nextLine();
        String replace_word = sc.nextLine();

        Set<String> words = new HashSet<>();
        allSequence(sen_word.toCharArray(),0, words);
        while (true) {
            boolean flag = false;
            for (String word : words) {
                if (sentence.contains(word)) {
                    sentence = sentence.replace(word, replace_word);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        System.out.println(sentence);
    }
    private void allSequence(char[] sen_word, int start, Set<String> words) {
        if (start == sen_word.length) {
            words.add(new String(sen_word));
        }

        for (int i = start; i < sen_word.length; i++) {
            swap(sen_word, start, i);
            allSequence(sen_word, start + 1, words);
            swap(sen_word, start, i);
        }
    }

    private void swap(char[] sen_word, int i, int j) {
        char tmp = sen_word[i];
        sen_word[i] = sen_word[j];
        sen_word[j] = tmp;
    }
}
