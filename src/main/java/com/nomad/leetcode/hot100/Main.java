package com.nomad.leetcode.hot100;

import java.util.*;

/**
 * @author nomad
 * @create 2020-09-05 3:08 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*System.out.println(new Main().maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));*/
        /*System.out.println(new Main().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));*/
        /*System.out.println(new Main().exist(new char[][]{
                {'a'}
        }, "a"));*/
        /*System.out.println(new Main().maxDotProduct2(new int[]{
                13,-7,12,-15,-7,8,3,-7,-5,13,-15,-8,5,7,-1,3,-11,-12,2,-12
        }, new int[]{
                -1,13,-4,-2,-13,2,-4,6,-9,13,-8,-3,-9
        }));*/
        System.out.println(new Main().distinctSubseqII("aba"));
    }

    /**
     * 75. 颜色分类 (荷兰国旗问题) O(n)且无需额外空间
     * 三个指针
     * p0:0的右边界
     * p2:2的左边界
     * cur:当前需要判断的元素
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0, p2 = len - 1, cur = 0;
        while (cur <= p2) {
            int tmp = 0;
            switch (nums[cur]) {
                case 0:
                    tmp = nums[p0];
                    nums[p0] = nums[cur];
                    nums[cur] = tmp;
                    p0++;
                    cur++;
                    break;
                case 1:
                    cur++;
                    break;
                case 2:
                    tmp = nums[p2];
                    nums[p2] = nums[cur];
                    nums[cur] = tmp;
                    p2--;
                    //cur++;
                    break;
            }
        }
    }

    /**
     * 78. 子集
     */
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets0(0, new ArrayList<>(), nums);
        return resList;
    }

    private void subsets0(int i, List<Integer> path, int[] nums) {
        resList.add(new ArrayList(path));

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            subsets0(j + 1, path, nums);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 79. 单词搜索
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist0(board, i, j, visited, word, 0))
                    return true;
            }
        }
        return false;
    }

    int[][] directions = new int[][]{
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    /**
     * @param board
     * @param r       下一个比较的行
     * @param c       下一个比较的列
     * @param visited
     * @param word    单词
     * @param i       当前已经比较的长度
     * @return
     */
    private boolean exist0(char[][] board, int r, int c, boolean[][] visited, String word, int i) {
        if (i == word.length()) { //注意递归出口顺序
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        if (visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        for (int j = 0; j < directions.length; j++) {
            int next_r = r + directions[j][0];
            int next_c = c + directions[j][1];
            if (exist0(board, next_r, next_c, visited, word, i + 1)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }

    /**
     * 84. 柱状图中最大的矩形
     * 单调栈(递增栈，存放下标)
     */
    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 2];
        System.arraycopy(heights, 0, h, 1, heights.length);
        h[heights.length + 1] = 0;
        Stack<Integer> index = new Stack<>();
        int res = 0;
        // 先放入哨兵，在循环里就不用做非空判断
        index.push(0);
        for (int i = 1; i < h.length; i++) {
            while (h[index.peek()] > h[i]) {
                int currHeight = h[index.pop()];
                int currWidth = i - index.peek() - 1;
                res = Math.max(res, currHeight * currWidth);
            }
            index.push(i);
        }

        return res;
    }

    /**
     * 85. 最大矩形
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

    /**
     * 101. 对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric0(root, root);
    }

    private boolean isSymmetric0(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isSymmetric0(p.left, q.right) && isSymmetric0(p.right, q.left);
    }

    /**
     * 102. 二叉树的层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            res.add(list);
        }

        return res;
    }

    /**
     * 104. 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 114. 二叉树展开为链表
     * 先序遍历
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        flatten(root.left);
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
        flatten(root.right);
    }

    /**
     * 121. 买卖股票的最佳时机
     * sale和buy两种状态
     */
    public int maxProfit(int[] prices) {
        int sale = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sale = Math.max(sale, prices[i] + buy);
        }
        return sale;
    }

    /**
     * 128. 最长连续序列
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> flag = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            flag.add(nums[i]);
        }

        int res = 0, count = 0;
        for (int num : nums) {
            while (flag.contains(num)) {
                num++;
                count++;
            }
            if (res < count) {
                res = count;
            }
            count = 0;
        }

        return res;
    }

    /**
     * 136. 只出现一次的数字
     * 位运算  所有的的元素异或就是结果
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

    /**
     * 139. 单词拆分
     */
    public HashMap<String, Boolean> hash = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        //方便check，构建一个哈希表
        for (String word : wordDict) {
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[j] = dp[i] && check(s.substring(i, j));
                if (dp[j]) break;
            }
        }

        return dp[s.length()];
    }

    public boolean check(String s) {
        return hash.getOrDefault(s, false);
    }

    /**
     * 141. 环形链表
     * Set
     * 快慢指针有规律，空间复杂度O（1）
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode s = head, f = head.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }

        return s == f;
    }

    /**
     * 142. 环形链表 II
     * Set
     * 快慢指针有规律，空间复杂度O（1）
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (visited.contains(p)) {
                break;
            }
            visited.add(p);
            p = p.next;
        }

        return p;
    }

    /**
     * 146. LRU缓存机制
     */
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRUCache(int capacity) {
            super(40, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

        @Override
        public Integer get(Object key) {
            Integer value = super.get(key);
            return value == null ? -1 : value;
        }
    }

    /**
     * 148. 排序链表
     * 归并排序（划分用快慢指针+合并）
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode s = head, f = head.next; //f=head会出现OOM错误，因为对于2个节点的链表没有分开导致递归出口出不去
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode tmp = s.next;
        s.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0); //链表头哨兵，便于统一操作
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = (left == null) ? right : left;

        return res.next;
    }

    /**
     * 152. 乘积最大子数组
     */
    public int maxProduct(int[] nums) {
        int len = nums.length, res = Integer.MIN_VALUE;
        for (int r = 0; r < len; r++) {
            int mul = 1;
            for (int l = r; l >= 0; l--) {
                mul *= nums[l];
                res = Math.max(res, mul);
            }
        }

        return res;
    }

    /**
     * 160. 相交链表
     * 换个方式消除长度差： 拼接两链表。
     * 设长-短链表为 C，短-长链表为 D （分别代表长链表在前和短链表在前的拼接链表），则当 C 走到长短链表交接处时，D 走在长链表中，且与长链表头距离为 长度差;
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.next : headB;
            hb = hb != null ? hb.next : headA;
        }
        return ha;
    }

    /**
     * 160. 相交链表
     * 也可以第一次遍历一起走先找到两个链表的长度差值，然后第二次遍历让长的那个先走对齐
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                break;
            }
            headB = headB.next;
        }

        return headB;
    }

    /**
     * 169. 多数元素
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int len = nums.length, half = len / 2;
        int res = 0;
        for (int i = 0; i < len; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            if (counts.get(nums[i]) > half) {
                res = i;
                break;
            }
        }

        return nums[res];
    }

    /**
     * 206. 反转链表
     * 递归
     * 迭代
     */
    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) { //递归出口
            return head;
        }

        ListNode cur = reverseList2(head.next); //返回反转后的新头
        head.next.next = head; //头结点接到尾部
        head.next = null;
        return cur;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }

        return pre;
    }

    /**
     * 287. 寻找重复数
     * 数组根据值看成链表
     * 问题转化为求带环链表的入口下标
     */
    public int findDuplicate(int[] nums) {
        int s = 0, f = 0; //一定要从同一个位置开始
        s = nums[s];
        f = nums[nums[f]];
        while (s != f) { //找第一次相遇下标
            s = nums[s];
            f = nums[nums[f]];
        }

        f = 0;//快指针从0开始，与s同速度走，直到相遇就是结果
        while (s != f) {
            f = nums[f];
            s = nums[s];
        }

        return s;
    }

    /**
     * 215. 数组中的第K个最大元素
     * 最小堆
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> res = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                res.offer(nums[i]);
            } else if (nums[i] > res.peek()) {
                res.poll();
                res.offer(nums[i]);
            }
        }

        return res.poll();
    }

    /**
     * 300. 最长上升子序列
     * dp[i]:以nums[i]结尾的子串的最长上升子序列
     * 还可以通过二分查找维护一个tail[i]数组做，表示长度为 i + 1 的所有上升子序列的结尾的最小值。
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }

        return res;
    }

    /**
     * 357. 计算各个位数不同的数字个数
     * dp[n]:n位数的满足条件总个数
     * 两位数 三位数 四位数 五位数
     * 一位数  0-9 一个10种   dp[1]=10;
     * 两位数 dp[2] 就是从0-9选两个数字，有10*9种选法 减去0开头非法二位数的9种 81 加上dp[1] 为91
     * 三位数 dp[3]就是10*9*8 +dp[2]再减去以0开头的非法三位数9*8
     * 即  dp[3]=dp[2]+10*9*8-9*8;
     * 回溯 递归
     */
    public int countNumbersWithUniqueDigits2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 10;
        dp[2] = 91;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + cal(10, i) - cal(9, i - 1);
        }

        return dp[n];
    }

    private int cal(int begin, int n) {
        if (n == 1) {
            return begin;
        }
        return begin * cal(begin - 1, n - 1);
    }

    int res = 0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        countNumbersWithUniqueDigits(nums, 0, n);
        return res + 1;
    }

    int[] tag = new int[10];

    public void countNumbersWithUniqueDigits(int[] nums, int start, int n) {
        if (n == 0) return;
        for (int i = 0; i < nums.length; i++) {
            if (start != i && tag[i] == 0) {
                tag[i] = 1;
                res++;
                countNumbersWithUniqueDigits(nums, i, n - 1);
                tag[i] = 0;
            }
        }
    }

    /**
     * 474. 一和零
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] counts = countZeroAndOnes(str);
            for (int i = m; i >= counts[0]; i--) { //取物品有后效性，不能重复取，所以这两个状态需要从后往前更新
                for (int j = n; j >= counts[1]; j--) {
                    dp[i][j] = Math.max(dp[i - counts[0]][j - counts[1]] + 1, dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    private int[] countZeroAndOnes(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - '0']++;
        }

        return res;
    }

    /**
     * 560. 和为K的子数组
     */
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length, res = 0;
        for (int r = 0; r < len; r++) {
            int sum = 0;
            for (int l = r; l >= 0; l--) {
                sum += nums[l];
                if (sum == k) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 560. 和为K的子数组
     * 超出内存限制
     * 58 / 81 个通过测试用例
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];
        int res = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j - 1];
                if (dp[i][j] == k) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 581. 最短无序连续子数组
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] p = Arrays.copyOf(nums, len);
        Arrays.sort(p);
        int l = 0, r = len - 1;
        while (l < len) {
            if (nums[l] != p[l]) {
                break;
            }
            l++;
        }
        while (r > l) {
            if (nums[r] != p[r]) {
                break;
            }
            r--;
        }

        return r - l + 1;
    }

    /**
     * 617. 合并二叉树
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }

        return t1 == null ? t2 : t1;
    }

    /**
     * 621. 任务调度器
     * 排序后分为多轮，每轮N+1个任务
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int res = 0;
        int len = tasks.length;
        for (int i = 0; i < len; i++) {
            counts[tasks[i] - 'A']++;
        }
        Arrays.sort(counts);

        while (counts[25] > 0) { //任务没有选完
            int i = 0; //标记当时选的是(倒数)第几个数
            while (i <= n) { //要选满n+1个数
                if (counts[25] == 0) { //没有数了
                    break;
                }
                if (25 - i >= 0 && counts[25 - i] > 0) { //如果n非常大，那么只有等待了（25 - i < 0）
                    counts[25 - i]--;
                }
                i++;
                res++;
            }

            Arrays.sort(counts); //注意每次要重新排序
        }

        return res;
    }

    /**
     * 647. 回文子串
     * dp
     * 注意扫描方向：
     * 填充右上角，每次从上到下，左下到右上
     */
    public int countSubstrings2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = len;
        for (int i = 0; i < len; i++) { //对角线
            dp[i][i] = true;
        }
        for (int j = 0; j < len; j++) { //后遍历列
            for (int i = 0; i < j; i++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (j - i == 1 && b) { //2个字符
                    res++;
                    dp[i][j] = true;
                } else if (b && dp[i + 1][j - 1]) { //大于2个字符
                    res++;
                    dp[i][j] = true;
                }
            }
        }

        return res;
    }

    /**
     * 647. 回文子串
     * 递归
     * 超时128 / 130 个通过测试用例
     */
    public int countSubstrings(String s) {
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (huiwen(sub)) {
                    res++;
                }
            }
        }

        return res;
    }
    private boolean huiwen(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        return (s.charAt(0) == s.charAt(s.length() - 1)) && huiwen(s.substring(1, s.length() - 1));
    }

    /**
     * 730. 统计不同回文子序列
     * dp[i][j]表示第i个字符和第j个字符之间包含的回文子串个数，主要i>j的dp元素需要置为0。
     * dp[i][j] = {
     * 1. s[i] != s[j]时, dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]
     * 2. s[i] == s[j]时, dp[i + 1][j - 1] * 2, 在所有的回文子串前后都加上s[i]。如果s[i..j]之间的子串有字符与s[i]相同，则会产生重复的回文子串，所以此时需要分情况进行调整
     * a. 如果没有重复与s[i]重复的字符，则会多产生两个回文子串，s[i]与s[ij]，如‘a’和‘aa’
     * b. 如果只有一个重复的字符，，则只会多产生一个回文子串，s[ij]，即'aa'
     * c. 如果存在多个，需要分别从起止点查找，找到第一个前后重复的字符l和r，分别用末尾字符替换后，会产生s[l][r]个重复的回文子串，需要减掉
     */
    public int countPalindromicSubsequences(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }

        int len = S.length();
        int[][] dp = new int[len][len];
        int mod = (int) (1e9 + 7);
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] * 2;
                    int l = i + 1, r = j - 1;
                    while (l <= r && S.charAt(l) != S.charAt(i)) {
                        l++;
                    }
                    while (l <= r && S.charAt(r) != S.charAt(j)) {
                        r--;
                    }
                    if (l > r) {
                        dp[i][j] += 2;
                    } else if (l == r) {
                        dp[i][j] += 1;
                    } else {
                        dp[i][j] -= dp[l + 1][r - 1];
                    }
                }

                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }

        return dp[0][len - 1];
    }

    /**
     * 739. 每日温度
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    res[i] += (j - i);
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 779. 第K个语法符号
     * K在奇数位时，与N-1, (K+1)/2 位置的值相同
     * K在偶数位时，与N-1, K/2 位置的值相反
     */
    private int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int res;
        if (k % 2 == 1) {
            res = kthGrammar(n - 1, (k + 1) / 2);
        } else {
            res = Math.abs(kthGrammar(n - 1, k / 2) - 1);
        }
        return res;
    }

    /**
     * 787. K 站中转内最便宜的航班
     * digesitela算法用优先队列
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] g = new int[n][n];//记录的是目的地
        for(int[] f : flights)
        {
            g[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0] - b[0]);
        //集合的参数是一个comparator的lambda表达式，默认升序
        heap.offer(new int[]{0, src, K + 1});//想集合添加一个记录费用、起点和中转站+1的数组
        //K + 1是还可以走过站点的个数

        while(!heap.isEmpty())//数组为空直接返回-1
        {
            int[] cur = heap.poll();//得到集合当中添加的数组
            int price = cur[0], place = cur[1], remainStops = cur[2];

            if(place == dst)//起点等于v中点
                return price;//返回0费用0

            if(remainStops > 0)//中转次数》0（至少执行一次，因为remain====k+1）
            {
                for(int i = 0; i < n; i++)//小于城市数量
                {
                    if(g[place][i] > 0)//表示起点----终点的中转路线是否存在
                    {
                        heap.offer(new int[]{price + g[place][i], i, remainStops - 1});
                        //如果存在 计算路费、起点的值、中转站-1
                    }
                }
            }
        }

        return -1;
    }

    /**
     * 940. 不同的子序列 II
     * dp[k] 表示 S[0 .. k) 可以组成的不同子序列的数目
     * dp[k] = 2 * dp[k - 1] - dp[last[S[k]] - 1]  减去dp[last[S[k]]是因为上次出现了同样的字符添加到尾部这样的操作
     */
    public int distinctSubseqII(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i + 1] -= dp[last[x]];
            dp[i + 1] %= MOD;
            last[x] = i;
        }

        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }

    /**
     * 978. 最长湍流子数组
     * -1 : <
     * 0 : =
     * 1 : >
     * [9,4,2,10,7,8,8,1,9] ====>>> [1,1,-1,1,-1,0,-1,1]
     * 问题转化为求-1,1交替的最长长度
     */
    public int maxTurbulenceSize(int[] A) {
        int res = 1;
        int start = 0; //标记块的起始下标
        for (int i = 1; i < A.length; i++) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (i == A.length - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) { //更新res和start的触发条件
                if (c != 0) {
                    res = Math.max(res, i - start + 1);
                }
                start = i;
            }
        }

        return res;
    }

    /**
     * 1458. 两个子序列的最大点积
     * dp[i][j]以nums1中下标i结尾和nums2中下标j结尾的最大点积
     * dp[i]长度为i的子序列的最大点积 超时
     */
    public int maxDotProduct2(int[] nums1, int[] nums2) {
        //数组长度
        int m = nums1.length;
        int n = nums2.length;

        //dp[i][j]为nums1以索引 i 结尾、nums2以索引 j 结尾的最大点积
        int[][] dp = new int[m][n];

        //base case，初始值
        dp[0][0] = nums1[0] * nums2[0];

        //当nums1数组只有一个数时，依次计算出dp[0][i]的最大点积（即nums2中每个数与nums1[0]相乘，取最大值）
        for (int i = 1; i < n; ++i) {
            dp[0][i] = Math.max(dp[0][i - 1], nums1[0] * nums2[i]);
        }

        //当nums2数组只有一个数时，依次计算出dp[i][0]的最大点积（即nums1中每个数与nums2[0]相乘，取最大值）
        for (int i = 1; i < m; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }

        //开始填充dp二维表格，对每行每列进行遍历
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                //dp[i][j]的最大值分为三种情况：
                // 不包含j dp[i][j-1]
                // 不包含i, dp[i-1][j]
                // 即包含i, 也包含j ，nums1[i] * nums2[j] 和 dp[i - 1][j - 1]
                // 因为dp[i - 1][j - 1]有可能是负数，如果为正数，就加（下面未注释的第2行），负数不加（下面未注释的第3行）
                // Math.max值能比较2个数，于是写成如下，dp[i][j]取这些情况的最大值即可
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i - 1][j - 1] + nums1[i] * nums2[j], dp[i][j]);
                dp[i][j] = Math.max(nums1[i] * nums2[j], dp[i][j]);
            }
        }

        //返回结果
        return dp[m - 1][n - 1];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = Math.min(len1, len2);
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 1; i <= len; i++) {
            List<int[]> subL1 = subList(nums1, i);
            List<int[]> subL2 = subList(nums2, i);
            for (int i1 = 0; i1 < subL1.size(); i1++) {
                for (int i2 = 0; i2 < subL2.size(); i2++) {
                    dp[i] = Math.max(dp[i], dotMult(subL1.get(i1), subL2.get(i2)));
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }

        return res;
    }

    private int dotMult(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += nums1[i] * nums2[i];
        }

        return res;
    }

    private List<int[]> subList(int[] nums, int len) {
        List<int[]> res = new ArrayList<>();
        subList0(nums, len, 0, 0, new int[len], res);

        return res;
    }

    private void subList0(int[] nums, int len, int start, int curLen, int[] curPath, List<int[]> res) {
        if (curLen == len) {
            int[] tmp = Arrays.copyOf(curPath, len);
            res.add(tmp);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curPath[curLen] = nums[i];
            subList0(nums, len, i + 1, curLen + 1, curPath, res);
        }
    }
}
