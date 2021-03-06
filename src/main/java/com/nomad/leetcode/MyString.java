package com.nomad.leetcode;

import java.util.*;
import java.util.regex.Pattern;

public class MyString {

    public static void main(String[] args) {
        /*char[][] a = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new MyString().solveSudoku(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("Arrays.toString(a[i]) = " + Arrays.toString(a[i]));
        }*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            /*int n = scanner.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.next();
            }*/
            //int m = scanner.nextInt();
            String a = scanner.next();
            //String b = scanner.next();
            int n = scanner.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.next();
            }
            System.out.println("new MyString().findSubstring(a, words) = " + new MyString().findSubstring(a, words));
        }
    }

    //最大非重复字符子串长度（多了很多重复判断）
    public int lengthOfLongestSubstring0(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            boolean[] flags = new boolean[128];
            flags[s.charAt(i)] = true;
            for (int j = i + 1; j < s.length(); j++) { //j可以不回溯
                if (flags[s.charAt(j)]) {
                    break;
                }
                flags[s.charAt(j)] = true;
                if (j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
    }

    //最大非重复字符子串长度（优化）
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    //最长回文子串（中心拓展法）
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //最长回文子串（c++版，动态规划，从段字符串到长字符串)
    /*string longestPalindrome(string s) {
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n));
        string ans;
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = 1;
                }
                else if (l == 1) {
                    dp[i][j] = (s[i] == s[j]);
                }
                else {
                    dp[i][j] = (s[i] == s[j] && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.size()) {
                    ans = s.substr(i, l + 1);
                }
            }
        }
        return ans;
    }*/

    //Z字形变换 遍历s，按行存储，控制移动方向（行的下标）
    public String convert(String s, int numRows) {

        if (numRows == 1 || s == null || s.isEmpty()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down;
            }
            curRow += down ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }

    //Z字形变换 找出s中字符位置和目标串中字符位置之间的关系+按行遍历直接输出
    //第0行：k(2⋅numRows−2) k=0,1...
    //第i行：k(2⋅numRows−2)+i和(k+1)(2⋅numRows−2)−i
    //第numRows-1行：k(2⋅numRows−2)+numRows−1 (i=numRows-1的特例)
    public String convert1(String s, int numRows) {

        if (numRows == 1 || s == null || s.isEmpty()) {
            return s;
        }

        int cycleLen = 2 * numRows - 2, n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) { //行
            for (int j = 0; j + i < n; j += cycleLen) { //列 步长为cycleLen
                sb.append(s.charAt(j + i)); //k(2⋅numRows−2)+i
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    sb.append(s.charAt(j + cycleLen - i)); //(k+1)(2⋅numRows−2)−i
            }
        }
        return sb.toString();
    }

    //字符串转整数
    public int myAtoi(String str) {

        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        if (!digitValidate(str)) {
            return 0;
        }

        boolean positive = true;
        int i = 0;
        long ret = 0;
        if (str.charAt(0) == '-') {
            positive = false;
            i = 1;
        }
        if (str.charAt(0) == '+') {
            i = 1;
        }
        for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
            ret = ret * 10 + str.charAt(i) - '0';
            if (ret >= Integer.MAX_VALUE && positive) return Integer.MAX_VALUE;
            if (ret > Integer.MAX_VALUE && !positive) return Integer.MIN_VALUE;
        }

        if (!positive) {
            ret = -ret;
        }

        return (int) ret;
    }

    private boolean digitValidate(String str) {
        char start = str.charAt(0);
        if (Character.isDigit(start) || ((start == '-' || start == '+') && str.length() > 1 && Character.isDigit(str.charAt(1)))) {
            return true;
        }
        return false;
    }

    //正则匹配  Pattern+Matcher
    public boolean isMatch(String s, String p) {

        return Pattern.matches(p, s);//一次性，完全匹配
    }

    //正则匹配 回溯法 按p分3种情况
    public boolean isMatch1(String s, String p) {
        if (p == null || s == null) {
            return false;
        }
        if (p.isEmpty()) { //""
            return s.isEmpty();
        }

        boolean first_match = (!s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') { //长度>=2且第二个是*
            return (isMatch(s, p.substring(2))) || //r个(a*)匹配失败
                    (first_match && isMatch(s.substring(1), p)); //第一个字符匹配成功就用p继续匹配s的子串
        } else { //长度=1或第二个不是*
            return first_match && isMatch(s.substring(1), p.substring(1)); ////第一个字符匹配成功就用p的子串继续匹配s的子串
        }
    }

    //正则匹配  动态规划（dp） 自顶向下
    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;

    public boolean isMatch2(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) ||
                        first_match && dp(i + 1, j, text, pattern));
            } else {
                ans = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    //正则匹配  动态规划（dp） 自底向上
    public boolean isMatch3(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    //最长公共前缀 垂直扫描
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //电话号码的字母组合  队列
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }

        String[] letter_map = {//0-9和字符之间的映射关系
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        res.add("");//把“”入队列
        for (int i = 0; i < digits.length(); i++) {
            String letter = letter_map[digits.charAt(i) - '0']; //要拼接的串
            int size = res.size();
            for (int j = 0; j < size; j++) { //遍历队列，旧的串出队拼接成新的串后入队
                String tmp = res.remove(0);
                for (int k = 0; k < letter.length(); k++) { //拼接串的长度
                    res.add(tmp + letter.charAt(k)); //旧的串+拼接串 拼接成新的串后入队
                }
            }
        }
        return res;
    }

    //电话号码的字母组合 回溯：深度遍历所有的情况，走通（到了边界条件）就把挡墙情况加入结果集，否则回退（注意状态重置）  此题没有回退
    public List<String> letterCombinations1(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    //有效的括号
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('}', '{');
        mappings.put(']', '[');
        mappings.put(')', '(');
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mappings.containsValue(ch)) {
                stack.add(ch);
            } else if (mappings.get(ch).equals(stack.peek())) {
                stack.pop();
            } else
                break;
        }
        return stack.empty();
    }

    //括号生成 动态规划(自底向上)
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list0 = new ArrayList<>();
        list0.add(""); //0对括号
        if (n <= 0) {
            return list0;
        }
        res.add(list0);
        List<String> list1 = new ArrayList<>();
        list1.add("()"); //1对括号
        res.add(list1);
        for (int i = 2; i <= n; i++) { //计算2~n对括号的情况: i对括号的情况="(p对括号)q对括号"
            List<String> listi = new ArrayList<>();
            for (int j = 0; j < i; j++) { //p,q遍历,p+q=i-1
                List<String> inner = res.get(j); //p对括号的情况
                List<String> outer = res.get(i - 1 - j); //q对括号的情况
                for (String in : inner) {
                    for (String out : outer) {
                        String tmp = "(" + in + ")" + out;
                        listi.add(tmp);
                    }
                }
            }
            res.add(listi);
        }

        return res.get(n);
    }

    //实现 strStr()
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //串联所有单词的子串
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return res;
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) { //key:word  value:单词在数组中出现的次数
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        int wordNum = words.length;
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {//分类以固定步长words.len向后移动 (感觉也可以分多个线程,每个线程处理一个类别,最后综合结果,需要用到CountDownLatch)
            for (int k = i; k <= s.length() - wordLen * wordNum; k += wordLen) {//每种类别需要遍历的次数,步长为单词组 (内部可优化, 前面已经比较的部分可以直接跳过)
                Map<String, Integer> hasWordCounts = new HashMap<>(); //(优化:可以不用重置,只需要移除第一个单词的计数)
                for (int j = 0; j < wordNum; j++) {//判断每一个单词
                    int start = k + j * wordLen;
                    int end = start + wordLen;
                    String tmpj = s.substring(start, end);
                    if (!wordCounts.containsKey(tmpj)) break;
                    int count = hasWordCounts.getOrDefault(tmpj, 0);
                    if (count == wordCounts.get(tmpj)) break;
                    hasWordCounts.put(tmpj, count + 1);
                    if (j == wordNum - 1) {
                        res.add(k);
                    }
                }
            }
        }

        return res;
    }

    //最长有效括号  栈
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>(); //存放字符下标
        stack.push(-1); //防止栈空pop抛异常并和正常匹配区分开

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) { //()匹配情况是不会为空的
                    stack.push(i); //防止栈空pop抛异常
                } else {
                    res = Math.max(res, i - stack.peek()); //每次()匹配都计算一次
                }
            }
        }

        return res;
    }

    //最长有效括号  动态规划
    public int longestValidParenthesesDP(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int res = 0;
        s = " " + s; //统一dp[i - 2]使用
        int[] dp = new int[s.length()]; //默认值都是0
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') { //.....()型
                    dp[i] = dp[i - 2] + 2; //第0个字符是空格
                } else if (s.charAt(i - 1 - dp[i - 1]) == '(') { //...((...))型
                    dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    //有效的数独
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                int number = ch - '0';
                int index = (i / 3) * 3 + j / 3;
                if (row[i][number] || col[j][number] || box[index][number]) {
                    return false;
                }
                row[i][number] = true;
                col[j][number] = true;
                box[index][number] = true;
            }
        }

        return true;
    }

    private char[][] board;
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] box = new boolean[9][10];
    boolean sudoSolved;

    //解数独 回溯
    public void solveSudoku(char[][] board) {
        this.board = board;
        if (board == null) {
            return;
        }

        //初始化状态
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int number = Character.getNumericValue(ch);
                    placeNumber(number, i, j);
                }
            }
        }

        //回溯求解
        backtrack(0, 0);
    }

    private void backtrack(int i, int j) { //回溯求数独解
        char ch = board[i][j];
        if (ch == '.') {
            for (int k = 1; k < 10; k++) { //依次尝试在(i,j)放入1~9这9个数字
                if (couldPlaceNumber(k, i, j)) {
                    placeNumber(k, i, j);
                    placeNextNumber(i, j); //在(i,j)的下一个位置放数
                    if (!sudoSolved) {
                        removeNumber(k, i, j); //如果(i,j)放number,后面行不通,移除(i,j)的number,尝试下一种情况
                    }
                }
            }
        } else {
            placeNextNumber(i, j);
        }
    }

    private void removeNumber(int number, int i, int j) { //重置board[i][j]的值和状态标志
        board[i][j] = '.';
        row[i][number] = false;
        col[j][number] = false;
        int index = (i / 3) * 3 + j / 3;
        box[index][number] = false;
    }

    private void placeNextNumber(int i, int j) { //(i,j)下一个位置放数
        if (i == 8 && j == 8) {
            sudoSolved = true;
        } else {
            if (j == 8) {
                backtrack(i + 1, 0);
            } else {
                backtrack(i, j + 1);
            }
        }
    }

    private boolean couldPlaceNumber(int number, int i, int j) { //(i,j)放number合法
        int index = (i / 3) * 3 + j / 3;
        return !row[i][number] && !col[j][number] && !box[index][number];
    }

    private void placeNumber(int number, int i, int j) { //把number放入board[i][j]并改变相应状态数组值
        board[i][j] = (char) ('0' + number);
        row[i][number] = true;
        col[j][number] = true;
        int index = (i / 3) * 3 + j / 3;
        box[index][number] = true;
    }

    //外观数列
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                int count = 1;
                char ch = sb.charAt(j);
                while (j + 1 < sb.length() && sb.charAt(j + 1) == ch) {
                    j++;
                    count++;
                }
                tmp.append(count);
                tmp.append(ch);
            }
            sb = tmp;
        }

        return sb.toString();
    }

    //字符串相乘  模拟手算 傻瓜做法
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if (num1.length() < num2.length()) {//交换:12*12345==>12345*12
            String swap = num1;
            num1 = num2;
            num2 = swap;
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            String tmp = multiplyOneNumber(num1, num2.charAt(i) - '0', num2.length() - 1 - i);
            sb = add(sb.toString(), tmp);
        }

        return sb.toString();
    }

    private String multiplyOneNumber(String num1, int i, int n) { //计算num1*i的字符串结果, n:结果后面补零的个数
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append('0');
        }
        int jinwei = 0;
        for (int j = num1.length() - 1; j >= 0; j--) {
            int tmp = (num1.charAt(j) - '0') * i;
            sb.insert(0, (tmp + jinwei) % 10);
            jinwei = (tmp + jinwei) / 10;
        }
        if (jinwei != 0) {
            sb.insert(0, jinwei);
        }

        return sb.toString();
    }

    private StringBuilder add(String sb, String tmp) {//计算sb+tmp的字符串结果
        StringBuilder res = new StringBuilder();
        int jinwei = 0, i = 0;
        while (i < sb.length() && i < tmp.length()) {
            int sum = sb.charAt(sb.length() - 1 - i) - '0' + tmp.charAt(tmp.length() - 1 - i) - '0' + jinwei;
            res.insert(0, sum % 10);
            jinwei = sum / 10;
            i++;
        }
        if (sb.length() == tmp.length() && jinwei > 0) {
            res.insert(0, jinwei);
            jinwei = 0;
        } else if (sb.length() < tmp.length()) {
            if (jinwei > 0) {
                for (int j = tmp.length() - 1 - i; j >= 0; j--) {
                    res.insert(0, (tmp.charAt(j) - '0' + jinwei) % 10);
                    jinwei = (tmp.charAt(j) - '0' + jinwei) / 10;
                }
            } else {
                res.insert(0, tmp.substring(0, tmp.length() - i));
            }
        } else {
            if (jinwei > 0) {
                for (int j = sb.length() - 1 - i; j >= 0; j--) {
                    res.insert(0, (sb.charAt(j) - '0' + jinwei) % 10);
                    jinwei = (tmp.charAt(j) - '0' + jinwei) / 10;
                }
            } else {
                res.insert(0, sb.substring(0, sb.length() - i));
            }
        }
        if (jinwei > 0) {
            res.insert(0, jinwei);
        }

        return res;
    }

    //字符串相乘  模拟手算 优化
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = num + res[p2];
                res[p2] = sum % 10;
                //此处的+=是为了处理进位用的，例如19*19，列出竖式看一下就知道了。
                res[p1] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            //这里的i==0是因为只可能出现首位为0的情况，例如一个三位数乘一个两位数不可能出现结果是一个三位数的情况。所以只需要判断首位即可。
            if (res[i] == 0 && i == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }

    //通配符匹配  超时
    public boolean isMatchWildcard(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0 || "*".equals(p)) {
            return true;
        }

        return doMatch(s, 0, p, 0);
    }

    private boolean doMatch(String s, int i, String p, int j) {
        if (i == s.length()) {
            while (j < p.length() && p.charAt(j) == '*') j++;
            return j == p.length();
        }
        if (i == s.length() - 1 && j == p.length() - 1) {
            return s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*';
        }
        if (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                return doMatch(s, i + 1, p, j + 1);
            } else if (p.charAt(j) == '*') {
                return doMatch(s, i, p, j + 1) || doMatch(s, i + 1, p, j);
            }
        }

        return false;
    }

    //通配符匹配 动态规划(自底向上)
    public boolean isMatchWildcard2(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        boolean[][] res = new boolean[len1 + 1][len2 + 2]; //boolean[i][j]:p的前i个字符和s的前j个字符是否匹配 true:匹配
        res[0][0] = true; //空串是匹配的
        //*****和空串也是匹配的
        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            res[i][0] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') { //状态转移方程1
                    res[i][j] = res[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') { //状态转移方程2
                    res[i][j] = res[i - 1][j] || res[i][j - 1];
                }
            }
        }

        return res[len1][len2];
    }

    //字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        int len = strs.length;
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                for (int j = i + 1; j < len; j++) {
                    if (!used[j] && match(strs[i], strs[j])) {
                        tmp.add(strs[j]);
                        used[j] = true;
                    }
                }
                res.add(tmp);
            }
        }

        return res;
    }

    private boolean match(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }

    //最后一个单词的长度
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String s1 = s.trim();
        int idx = s1.lastIndexOf(' ');

        return (idx < 0) ? s1.length() : s1.length() - idx - 1;
    }

    //文本左右对齐
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int currentLen = words[0].length(); //累计单词长度
        int wordIdx = 0; //每行开始单词的数组下标

        for (int i = 1; i < words.length; i++) {
            if (currentLen + words[i].length() + (i - wordIdx) <= maxWidth) { //i:单词间隙个数
                currentLen += words[i].length();
            } else { //一行结束
                StringBuilder sb = new StringBuilder();
                int avgSpace, plusNum = 0; //avgSpace:每个间隙最少的空格数  plusNum:需要加一个空格的间隙数
                if (i - wordIdx == 1) { //只有一个单词+空格
                    avgSpace = maxWidth - currentLen;

                    sb.append(words[wordIdx]);//把上一行放入结果中
                    for (int j = 0; j < avgSpace; j++) {
                        sb.append(' ');
                    }
                } else { //多个单词+间隙空格
                    avgSpace = (maxWidth - currentLen) / (i - wordIdx - 1);
                    plusNum = (maxWidth - currentLen) % (i - wordIdx - 1);

                    for (int j = wordIdx; j < i; j++) { //把上一行放入结果中
                        sb.append(words[j]);
                        if (j < i - 1) {
                            for (int k = 0; k < avgSpace; k++) {
                                sb.append(' ');
                            }
                            if (plusNum > 0) {
                                sb.append(' ');
                                plusNum--;
                            }
                        }
                    }
                }
                res.add(sb.toString());

                wordIdx = i;
                currentLen = words[i].length();
            }
        }
        //处理最后一行
        StringBuilder sb = new StringBuilder();
        for (int i = wordIdx; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(' ');
            } else {
                for (int j = 0; j < (maxWidth - currentLen - (i - wordIdx)); j++) {
                    sb.append(' ');
                }
            }
        }
        res.add(sb.toString());

        return res;
    }

    //简化路径
    public String simplifyPath(String path) {
        String[] names = path.split("/"); //此时数组有"路径"、""、"."、".."这四种情况
        Stack<String> res = new Stack<>();
        for (int i = 0; i < names.length; i++) {
            if (!res.empty() && names[i].equals("..")) {
                res.pop();
            } else if (!names[i].equals(".") && !names[i].equals("") && !names[i].equals("..")) {
                res.push(names[i]);
            }
        }
        if (res.empty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        int size = res.size();
        for (int i = 0; i < size; i++) {
            sb.insert(0, "/" + res.pop());
        }

        return sb.toString();
    }

    //编辑距离  动态规划(自底向上)
    //dp\[i]\[j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
    //当 word1\[i] == word2\[j]，dp\[i]\[j] = dp\[i-1]\[j-1]；
    //当 word1\[i] != word2\[j]，dp\[i]\[j] = min(dp\[i-1]\[j-1], dp\[i-1]\[j], dp\[i]\[j-1]) + 1
    //其中，dp\[i-1]\[j-1] 表示替换操作，dp\[i-1]\[j] 表示删除操作，dp\[i]\[j-1] 表示插入操作。
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] res = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    res[i][j] = Math.max(i, j);
                } else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = Math.min(res[i - 1][j - 1], Math.min(res[i - 1][j], res[i][j - 1])) + 1;
                }
            }
        }

        return res[len1][len2];
    }
}
