package com.nomad.xz.ne;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nomad
 * @create 2020-08-06 4:35 PM
 */
public class Main_20 {
    public static void main(String[] args) {
        //new Main_20().test();
    }

    /**
     * 序列交换
     */
    public void seqSwap(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int oddCounts = 0;//奇数的个数
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] % 2 != 0) {
                oddCounts++;
            }
        }

        if (oddCounts > 0 && oddCounts < n) { //全是奇数或者全是偶数，直接输出并返回， 否则只需排个序就行
            Arrays.sort(nums);
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[n - 1]);
    }

    /**
     * 小易的英语软件
     */
    public void enSoftware(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] grades = new int[n];
        int[] counts = new int[151];
        for(int i = 0; i < n; i++) {
            int grade = scanner.nextInt();
            grades[i] = grade;
            counts[grade]++;
        }
        int q = scanner.nextInt();
        for(int i = 0; i < q; i++) {
            int grade = grades[scanner.nextInt() - 1], count = 0;
            while(grade >= 0){
                count += counts[grade--];
            }
            System.out.printf("%f\n", ((count - 1) * 100.0 / n));
        }
    }

    /**
     * 序列维护
     */
    public void seqMaintain(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = scanner.nextInt();

        for(int i = 0; i < q; i++){
            int x = scanner.nextInt(), res = 0;;
            for(int j = 0; j < n; j++) {
                if(nums[j] >= x) {nums[j]--; res++;}
            }
            System.out.println(res);
        }
    }

    /**
     * 数字圆环
     */
    public boolean numberRing(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 3) {
            return false;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE, mmax = Integer.MIN_VALUE, mmmax = Integer.MIN_VALUE; //最大的三个数
        if (nums[0] < nums[1]) {
            if (nums[0] < nums[2]) {
                max = nums[0];
                if (nums[1] > nums[2]) {
                    mmax = nums[2];
                    mmmax = nums[1];
                } else {
                    mmax = nums[1];
                    mmmax = nums[2];
                }
            }
        }
        for (int i = 3; i < n; i++) {
            if (nums[i] > mmmax) {
                mmmax = nums[i];
                mmax = mmmax;
                max = mmax;
            } else if (nums[i] > mmax) {
                mmax = nums[i];
                max = mmax;
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max + mmax > mmmax;  //只要次大的两个数之和>最大的数就是true  思路：首先对数组进行从大到小排序，排序后，只剩最后一个可能不满足条件，这个时候与倒数第二个交换如果满足的话就可以，所以直接判断最后三个数即可
    }
}
