package com.nomad.leetcode;

import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

@Log
public class MyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            /*int m = scanner.nextInt();
            int n = scanner.nextInt();*/
            String s = scanner.nextLine();
            String s1 = scanner.nextLine();

            /*int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }*/

            /*int nums[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }*/

            System.out.println("new MyNumber().addBinary(s, s1) = " + new MyNumber().addBinary(s, s1));
        }
    }

    //两个正序数组的中位数
    //二分法找第k小的元素  奇数：k=totalLength / 2   偶数：k=[(totalLength / 2 - 1) + (totalLength / 2)] / 2
    //时间O(logm+n) 空间O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    //整数反转  整数->String->整数
    public int reverse(int x) {

        if (x == Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }
        String s = "" + x;
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        long ret = Long.valueOf(s);
        if (!positive) ret = -ret;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ret;
    }

    //回文数
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int sum = 0, x1 = x;
        while (x1 != 0) {
            int m = x1 / 10, n = x1 % 10;
            sum = sum * 10 + n;
            x1 = m;
        }
        return (sum == x);
    }

    //盛最多水的容器 双指针
    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    //整数转罗马数字 贪心算法 同找零钱问题：用最少的张数，每次都用面值尽量大的
    public String intToRoman(int num) {

        int nums[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                sb.append(nums[index]);
                num -= nums[index];
            }
            index++;
        }

        return sb.toString();
    }

    //整数转罗马数字 针对题目最大数不超过3999，用数组枚举出来
    public String intToRoman1(int num) {

        String[][] str = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

        StringBuilder sb = new StringBuilder();
        sb.append(str[3][num / 1000]);
        sb.append(str[2][num / 100 % 10]);
        sb.append(str[1][num / 10 % 10]);
        sb.append(str[0][num % 10]);
        return sb.toString();
    }

    //罗马数字转整数 hash
    //首先将所有的组合可能性列出并添加到哈希表中
    //然后对字符串进行遍历，由于组合只有两种，一种是 1 个字符，一种是 2 个字符，其中 2 个字符优先于 1 个字符
    //先判断两个字符的组合在哈希表中是否存在，存在则将值取出加到结果 ans 中，并向后移2个字符。不存在则将判断当前 1 个字符是否存在，存在则将值取出加到结果 ans 中，并向后移 1 个字符
    //遍历结束返回结果 ans
    public int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int res = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return res;
    }

    //删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums.length;
        for (int i = 1; i < res; i++) {
            int j = i;
            while (j < res && nums[j] == nums[i - 1]) j++; //注意j < res条件
            if (j > i) {
                res -= (j - i);
                for (int k = j; k < nums.length; k++) {
                    nums[k - (j - i)] = nums[k];
                }
            }
        }

        return res;
    }

    //移除元素
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums.length;
        for (int i = 0; i < res; ) {
            if (nums[i] == val) {
                nums[i] = nums[res - 1];
                res--;
                continue;
            }
            i++;
        }

        return res;
    }

    //两数相除  位运算加倍减去除数+转为负数处理省去越界考虑
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int res = 0;
        boolean sign = (dividend > 0) ^ (divisor > 0); //true: 异号,商<0
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            int tmp = divisor, c = 1; //tmp:每次减去的数(倍数增长)  c:计数,即减去的除数个数(商)
            while (dividend - tmp <= tmp) {
                tmp = tmp << 1;
                c = c << 1;
            }
            dividend -= tmp;
            res += c;
        }
        return sign ? -res : res;
    }

    //下一个排列
    //从右向左扫描,升序直接跳过(因为升序的下一个排列是最小值,只需要反转即可.e.g. 6,5,4->4,5,6),
    //直到遇到降序:a\[i-1]<a\[i],就把a\[i-1]和a\[j](j>=i)交换并且保证a\[i-1]右侧仍是升序,
    //最后反转a\[i-1]~a\[n.length-1]即可
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) { //从右向左找到第一个降序的位置i,i+1
            i--;
        }
        if (i >= 0) { //找到了
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) { //从右向左找第一个比a[i]大的数,即要交换的数,且仍然保持a[i]右侧升序
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1); //从i+1开始反转
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    //搜索旋转排序数组
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[l] <= target && target <= nums[mid]) {  //l - mid不包含旋转且target在其中
                h = mid;
            } else if (nums[l] > nums[mid] && nums[mid] >= target) { //l - mid包含旋转且target在其中未旋转部分
                h = mid;
            } else if (nums[l] > nums[mid] && target >= nums[l]) { //l - mid包含旋转且target在其中旋转部分
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l] == target ? l : -1;
    }

    // 在排序数组中查找元素的第一个和最后一个位置  二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }

        int i = Arrays.binarySearch(nums, target); //nums需要有序, 对于包含多个相同的target,索引结果取决于target的位置.如不存在target,返回"-插入位置"
        if (i >= 0) {
            int start = i - 1;
            int end = i + 1;
            while (start >= 0 && nums[start] == target) start--;
            while (end < nums.length && nums[end] == target) end++;
            res[0] = start + 1;
            res[1] = end - 1;
        }
        return res;
    }

    //搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        while (i < nums.length && target > nums[i]) {
            i++;
        }

        return i;
    }

    //组合总和  回溯法 DFS 递归
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates); //帮助剪枝,提前终止搜索
        dfs(candidates, candidates.length, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param length     输入数组的长度，冗余变量
     * @param target     剩余数值
     * @param i          本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates, int length, int target, int i, ArrayDeque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {//找到一种方案
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < length; j++) {
            if (target < candidates[j]) { //剪枝,提前终止
                break;
            }
            if (j > i && candidates[j] == candidates[j - 1]) { //小剪枝,跳过重复情况
                continue;
            }
            path.addLast(candidates[j]);
            dfs(candidates, length, target - candidates[j], j, path, res); //从j开始,避免res中path重复
            path.removeLast(); //恢复状态(删除刚才添加的节点值),下一轮DFS分支搜搜
        }
    }

    //组合总和 II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates); //帮助剪枝,提前终止搜索
        dfs2(candidates, candidates.length, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param length     输入数组的长度，冗余变量
     * @param target     剩余数值
     * @param i          本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs2(int[] candidates, int length, int target, int i, ArrayDeque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {//找到一种方案
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < length; j++) {
            if (target < candidates[j]) { //大剪枝,提前终止
                break;
            }
            if (j > i && candidates[j] == candidates[j - 1]) { //小剪枝,跳过重复情况
                continue;
            }
            path.addLast(candidates[j]);
            dfs2(candidates, length, target - candidates[j], j + 1, path, res);// 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            path.removeLast(); //恢复状态(删除刚才添加的节点值),下一轮DFS分支搜搜
        }
    }

    //缺失的第一个正数  将数组视为hash表进行原地hash
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) { //满足条件就交换  nums[nums[i] - 1] != nums[i]:已经在正确位置的不用交换,重复数字不用交换
                int targetIndex = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    //接雨水
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int res = 0, maxi = 0;
        for (int i = 1; i < height.length; i++) { //找到最大高度的柱子
            if (height[maxi] < height[i]) {
                maxi = i;
            }
        }
        //计算maxi左边的积水面积
        int leftHeight = height[0];
        for (int i = 1; i < maxi; i++) {
            if (leftHeight <= height[i]) {
                leftHeight = height[i];
            } else {
                res += leftHeight - height[i];
            }
        }

        //计算maxi右边的积水面积
        int rightHight = height[height.length - 1];
        for (int i = height.length - 2; i > maxi; i--) {
            if (rightHight <= height[i]) {
                rightHight = height[i];
            } else {
                res += rightHight - height[i];
            }
        }

        return res;
    }

    //跳跃游戏 II  反向查找
    public int jump(int[] nums) {
        int res = 0, pos = nums.length - 1;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    pos = i;
                    res++;
                }
            }
        }

        return res;
    }

    //跳跃游戏 II  正向查找 O(n)
    public int jump2(int[] nums) {
        int len = nums.length, res = 0, maxPos = 0, end = 0; //end维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1
        for (int i = 0; i < len - 1; i++) { //不需要到最后一个元素
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                res++;
            }
        }

        return res;
    }

    //全排列(隐式树) 回溯 主函数处理一些特殊情况和定义状态值,递归函数是核心(递归出口+递归体),关键是函数参数确定
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 1) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        //递归出口 对应结果集中一种情况
        if (depth == len) {
            res.add(new ArrayList<>(path)); //path可以理解为全局的,所有res.add(path)是错的
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, depth + 1, path, used, res);
                used[i] = false; //回溯(状态重置)
                path.remove(path.size() - 1);
            }
        }
    }

    //全排列 II 剪枝去重复 提前排好序
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 1) {
            return res;
        }

        Arrays.sort(nums);

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs2(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs2(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        //递归出口 对应结果集中一种情况
        if (depth == len) {
            res.add(new ArrayList<>(path)); //path可以理解为全局的,所有res.add(path)是错的
            return;
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) { //剪枝去重
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs2(nums, len, depth + 1, path, used, res);
                used[i] = false; //回溯(状态重置)
                path.remove(path.size() - 1);
            }
        }
    }

    //旋转图像
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }

        for (int i = 0; i < matrix.length / 2; i++) { //4:2次  3:1次  圈数
            for (int j = 0; j < matrix[0].length - 1 - 2 * i; j++) { //每圈交换次数
                int row = i, col = i + j, tmp = matrix[row][col];
                for (int k = 0; k < 3; k++) { //每次交换4个数字
                    matrix[row][col] = matrix[matrix[0].length - 1 - col][row];
                    int t = row;
                    row = matrix[0].length - 1 - col;
                    col = t;
                }
                matrix[row][col] = tmp;
            }
        }
    }

    //Pow(x, n)
    public double myPow(double x, int n) {
        /*//栈溢出
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * myPow(x, n - 1);
        } else {
            return 1 / (x * myPow(x, -n - 1));
        }*/
        //return Math.pow(x, n);
        return n >= 0 ? quickPow(x, n) : 1 / quickPow(x, n);
    }

    private double quickPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double y = quickPow(x, n / 2);
        return (n % 2 == 0) ? y * y : y * y * x;
    }

    //最大子序和 贪心
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return res;
    }

    //螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1; //上下左右边界
        while (true) {
            for (int i = l; i <= r; i++) { //遍历上边界
                res.add(matrix[u][i]);
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) {//遍历右边界
                res.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {//遍历下边界
                res.add(matrix[d][i]);
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) {//遍历左边界
                res.add(matrix[i][l]);
            }
            if (++l > r) break;
        }

        return res;
    }

    //跳跃游戏   从左往右倒着判断可以到达尾部的位置，然后更新当前尾部递归调用
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        return doJump(nums, end);
    }

    private boolean doJump(int[] nums, int end) {
        if (end == 0) return true;
        for (int i = 0; i < end; i++) {
            if (i + nums[i] >= end) {
                return doJump(nums, i);
            }
        }
        return false;
    }

    //合并区间
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]); //根据数组第一个元素升序排好序后多种情况变为3种（a包含b,a∩b和a<b）

        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) { //不合并
                res[++idx] = interval;
            } else { //合并,更新右边界
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }

    //插入区间
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = Arrays.copyOf(intervals[i], 2);
        }
        res[intervals.length] = newInterval;

        return merge(res);
    }

    //螺旋矩阵 II
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return null;
        }

        int[][] res = new int[n][n];
        int u = 0, d = n - 1, l = 0, r = n - 1, count = 1;
        while (true) {
            for (int i = l; i <= r; i++) { //上边界
                res[u][i] = count++;
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) {//右边界
                res[i][r] = count++;
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {//下边界
                res[d][i] = count++;
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) {//左边界
                res[i][l] = count++;
            }
            if (++l > r) break;
        }

        return res;
    }

    //第k个排列  从右往左找第一个降序的位置，和右边刚好大于它的数交换，然后从i+1反转。起始串为123...n，重复k次
    //         参考31题下一个排列
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        while (--k > 0) {
            nextPermutation(nums);
        }

        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    //不同路径  C(m+n-2, n-1)=C(m+n-2, m-1)
    public int uniquePaths(int m, int n) {
        long res = 1;
        for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
            res *= (m + n - 2 - i);
            res /= (i + 1);
        }

        return (int) res;
    }

    //不同路径 II  动态规划dp\[i,j]=dp\[i-1,j]+dp\[i,j-1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i > 0 || j > 0) && obstacleGrid[i][j] == 0) {
                    if (i > 0 && obstacleGrid[i-1][j] == 0) {
                        res[i][j] += res[i-1][j];
                    }
                    if (j > 0 && obstacleGrid[i][j - 1] == 0) {
                        res[i][j] += res[i][j - 1];
                    }
                }
            }
        }

        return res[m-1][n-1];
    }

    //最小路径和 动态规划dp\[i,j]=min(dp\[i-1,j]+grid\[i,j], dp\[i,j-1]+grid\[i,j])
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return Integer.MIN_VALUE;
        }

        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                }
            }
        }

        return res[m - 1][n - 1];
    }

    //有效数字  BigDecimal未通过：44e016912630333 （小数位数太多）
    public boolean isNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }

        try {
            new BigDecimal(s.trim());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    //有效数字  正则  未通过：导入java.util.regex;还是找不到符号
    public boolean isNumber2(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }

        String regex = "[-+]?[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?";
        return Pattern.compile(regex).matcher(s.trim()).matches();
    }

    //有效数字  常规做法
    public boolean isNumber3(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }

        boolean numSeen=false, dotSeen=false, eSeen=false;
        s = s.trim();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                numSeen=true;
            }else if(s.charAt(i)=='.'){
                if(dotSeen||eSeen){
                    return false;
                }
                dotSeen=true;
            }else if(s.charAt(i)=='E'||s.charAt(i)=='e'){
                if(eSeen||!numSeen){
                    return false;
                }
                eSeen=true;
                numSeen=false;
            }else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                if(i!=0&&s.charAt(i - 1)!='e'&&s.charAt(i - 1)!='E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return numSeen;
    }

    //加一
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (; i >= 0; i--) { //从后往前找第一个不是9的位置
            if (digits[i] != 9) {
                break;
            }
        }
        if (i == digits.length - 1) {//没找到
            int[] res = Arrays.copyOf(digits, digits.length);
            res[digits.length - 1]++;
            return res;
        } else if (i >= 0) {//找到，且不是999...99情况
            int[] res = new int[digits.length];
            for (int j = 0; j <= i; j++) {
                res[j] = digits[j];
            }
            res[i]++;
            return res;
        } else { //找到，且是进位情况
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
    }

    //二进制求和
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len_a = a.length(), len_b = b.length(), jinwei = 0;
        for (int i = len_a - 1, j = len_b - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = jinwei;
            sum += (i >= 0) ? Character.getNumericValue(a.charAt(i)) : 0;
            sum += (j >= 0) ? Character.getNumericValue(b.charAt(j)) : 0;
            sb.insert(0, sum % 2);
            jinwei = sum / 2;
        }
        if (jinwei > 0) sb.insert(0, 1);

        return sb.toString();
    }

    //x 的平方根
    public int mySqrt(int x) {
        //return (int) Math.sqrt(x);
        long x0 = x;
        while (x0 * x0 > x) {
            x0 = (x0 + x / x0) / 2;
        }

        return (int) x0;
    }

    //爬楼梯  动态规划自顶向下 超时
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //爬楼梯  动态规划自底向上
    public int climbStairs2(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res[n];
    }
}