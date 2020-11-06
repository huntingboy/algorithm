package com.nomad.xz.jsy;

import java.util.Scanner;

/**
 * 金山云
 */
public class Main_21 {
    public static void main(String[] args) {
        new Main_21().x1();
    }

    /**
     * 5的个数
     */
    public void x2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        /*while (n > 0) {
            int resident = n % 10;
            if (resident >= 5) {
                res++;
            }
            n = n / 10;
            res += n;
        }*/
        for (int i = 1; i <= n; i++) {
            res += count5("" + i);
        }

        System.out.println(res);
    }

    private int count5(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if(c == '5') res++;
        }
        return res;
    }

    /**
     * 子树的权重
     */
    public void x1(){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String[] numss = sc.nextLine().split(" ");
            if (numss.length == 1) {
                System.out.println("Yes");
                continue;
            }
            int[] nums = new int[numss.length + 1];
            for (int j = 1; j < nums.length; j++) {
                nums[j] = Integer.parseInt(numss[j - 1]);
            }

            boolean flag = true;
            for (int j = 1; j <= (nums.length - 1) / 2; j++) {
                int l = calWeight(nums, j * 2);
                int r = calWeight(nums, j * 2 + 1);
                if(l == r) {
                    System.out.println("Yes");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("No");
            }
        }
    }

    private int calWeight(int[] nums, int i) {
        if (i > (nums.length - 1) / 2) {
            return nums[i];
        }
        int lchild = i * 2, rchild = i * 2 + 1;
        return calWeight(nums, lchild) + calWeight(nums, rchild) + nums[i];
    }
}
