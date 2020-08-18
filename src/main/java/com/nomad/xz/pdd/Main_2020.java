package com.nomad.xz.pdd;

import java.util.*;

/**
 * @author nomad
 * @create 2020-08-17 5:21 PM
 */
public class Main_2020 {
    public static void main(String[] args) {
        new Main_2020().maxkth();
    }

    /**
     * 二维表第k大数
     * 0.3ac 数组越界
     * 可以用二分查找
     */
    public void maxkth(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res.add((long)(i + 1) * (j + 1));
            }
        }
        Collections.sort(res, Comparator.reverseOrder());

        System.out.println(res.get(k - 1));
    }

    /**
     * 骰子期望
     * p(x=k)=p(x<=k)-p(x<=k-1)
     */
    public void expect(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }
        sc.close();

        double res = 0, pre = 0;
        for (int i = 1; i <= max; i++) {
            double tmp = 1.0;
            for (int j = 0; j < n; j++) {
                tmp *= (double)Math.min(nums[j], i) / nums[j];
            }
            res += (tmp - pre) * i;
            pre = tmp;
        }

        System.out.printf("%.2f\n", res);
    } 

    /**
     * 多多的电子字典
     * 0.4ac 数组越界
     * 还可以建模为二叉树的先序遍历
     */
    public void dict(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long k = sc.nextInt();
        Stack<Character> stack = new Stack<>();
        for (int i = 0, a = 0, b = 0; i < k; i++) {
            if (a < n) {
                a++;
                stack.push('a');
            } else if (b < m) {
                b++;
                stack.push('b');
            } else {
                while (stack.peek() == 'a') {
                    a--;
                    stack.pop();
                }
                if (a == 0 && b == m) {
                    for (int j = 0; j < n; j++) {
                        stack.push('a');
                    }
                    break;
                }
                while (!stack.empty()) {
                    if (stack.pop() == 'b') {
                        b--;
                    } else {
                        a--;
                        break;
                    }
                }

                b++;
                stack.push('b');
            }
        }

        int i = 0;
        while (i < stack.size()) System.out.print(stack.get(i++));
    }

    /**
     * 多多的排列函数
     */
    public void pailieFunc2() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.print(Math.ceil(n / 2F) % 2 == 0 ? 0 : 1);
            System.out.print(" ");
            System.out.println(Math.floorDiv(n, 2) % 2 == 0 ? n : n - 1);
        }
    }

    /**
     * 多多的排列函数
     * 超时 因为把全排列都求出来了，实际上有规律
     */
    public void pailieFunc(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            boolean[] flag = new boolean[n];
            List<List<Integer>> pailies = new ArrayList<>();
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                List<Integer> pailie = new ArrayList<>();
                flag[j] = true;
                pailie.add(j + 1);
                pailie0(n, flag, pailie, pailies);
                pailie.clear();
                flag[j] = false;
            }
            for (List<Integer> p : pailies) {
                int res = func(p);
                max = Math.max(max, res);
                min = Math.min(min, res);
            }

            System.out.println(min + " " + max);
        }
    }

    private int func(List<Integer> p) {
        int[] f = new int[p.size()];
        f[0] = p.get(0);
        for (int i = 1; i < p.size(); i++) {
            f[i] = Math.abs(f[i - 1] - p.get(i));
        }
        return f[p.size() - 1];
    }

    private void pailie0(int n, boolean[] flag, List<Integer> pailie, List<List<Integer>> pailies) {
        if (pailie.size() == n) {
            pailies.add(new ArrayList<>(pailie));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                pailie.add(i + 1);
                pailie0(n, flag, pailie, pailies);
                pailie.remove(pailie.size() - 1);
                flag[i] = false;
            }
        }
    }

    /**
     * 多多的魔术盒子
     * ceil(logn) 二进制位数
     */
    public void magixBox(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(Integer.toBinaryString(n).length()); // Math.ceil(Math.log(n))
        }
    }
}
