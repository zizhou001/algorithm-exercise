package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-25 11:06
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence s = new LongestCommonSubsequence();
        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]表示字符串 text1[0,i] 与 text2[0,j] 的最长公共子序列
        // 若text1为空，dp[0][j] = 0；若text2为空，dp[i][0] = 0
        // 因此，边界情况：当i == 0 || j == 0 则，dp[i][j] = 0
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char chInText1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char chInText2 = text2.charAt(j - 1);
                if (chInText1 == chInText2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
