package dp;

/*
 * http://www.lintcode.com/zh-cn/problem/longest-common-subsequence/
 * 0. 不能排序，求最长公共子序列的长度， 2 sequences -> dp
 * 1. f[i][j] -> 两个序列第i个字符和第j个字符时的LCS
 * 2. f[i][j] = f[i - 1][j - 1] + 1如果s[i] = s[j]; f[i][j] = max(f[i - 1][j], f[i][j - 1])如果s[i] != s[j]
 * 3. f[i][0] = 0 f[0][j] = 0
 * 4. f[m][n]
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String A, String B) {
        if ((A == null) || (B == null)) {
            return 0;
        }
        int[][] lcs = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[A.length()][B.length()];
    }
}
