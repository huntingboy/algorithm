package com.nomad.leetcode;

import java.util.*;

public class MyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println("new MyNumber().trap(nums) = " + new MyNumber().trap(nums));
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
        if(!positive) ret = -ret;
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
        for (int i = 0; i < s.length();) {
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
        for (int i = 0; i < res;) {
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
        reverse(nums, i+1); //从i+1开始反转
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
     * @param length        输入数组的长度，冗余变量
     * @param target    剩余数值
     * @param i      本轮搜索的起点下标
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
     * @param length        输入数组的长度，冗余变量
     * @param target    剩余数值
     * @param i      本轮搜索的起点下标
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
        if (height == null || height.length < 2) {
            return 0;
        }

        int res = 0;
        int i = 0, j = 0, exclude = 0;
        while (j < height.length - 1) { //左边找递减序列,右边找递增序列
            i = j;
            exclude = 0;
            while (i + 1 < height.length && height[i] <= height[i + 1]) { //找左边递减开始的位置a[i] > a[i+1]
                i++;
            }
            j = i;
            while (j + 1 < height.length && height[j] >= height[j + 1]) { //跳过递减的
                j++;
            }
            while (j + 1 < height.length && height[j] <= height[j + 1]) { //找右边递增结束的位置a[j] > a[j+1]并累加右边递增侧柱子占用的面积
                j++;
            }
            int w = j - i - 1, h = Math.min(height[i], height[j]);
            //找出(i,j)之间柱子占用的
            while (i < j - 1) {
                i++;
                int tmp = height[i] > h ? h : height[i];
                exclude += tmp;
            }
            res += w * h - exclude;
        }

        return res;
    }
}
