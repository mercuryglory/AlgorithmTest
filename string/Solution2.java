package string;

/**
 * created by mercury on 2020-04-08
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution2 {


    /**
     * 动态规划
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int m = str.length;
        int n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (pattern[j - 1] != '*') {
                    if (isMatch(str, pattern, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = isMatch(str, pattern, i, j - 1) ? dp[i - 1][j] || dp[i][j - 2] : dp[i][j - 2];
                }

            }
        }
        return dp[m][n];

    }

    private boolean isMatch(char[] str, char[] pattern, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (pattern[j - 1]=='.') {
            return true;
        }
        return str[i - 1] == pattern[j - 1];
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.match("aaa".toCharArray(), "ab*ac*a".toCharArray()));

    }
}
