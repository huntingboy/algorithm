package com.nomad.leetcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(new MyString().myAtoi(input));
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
            if(ret >= Integer.MAX_VALUE && positive) return Integer.MAX_VALUE;
            if(ret > Integer.MAX_VALUE && !positive) return Integer.MIN_VALUE;
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
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    //正则匹配  动态规划（dp） 自底向上
    public boolean isMatch3(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
