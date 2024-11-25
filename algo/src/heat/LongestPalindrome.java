package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-25 9:40
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome s = new LongestPalindrome();
        System.out.println(s.longestPalindrome("babad"));
    }

    /**
     * 对于子串s,令dp[i][j]表示s[i,j]是否是回文
     * 若dp[i][j] = true,则dp[i+1][j-1]必然也为回文
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;

        // 令dp[i][j]表示s[i,j]是否为回文
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            // 初始化长度为1的子串是回文
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();


        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len; i++) {
                // 确定右边界
                int r = l + i - 1;
                if (r >= len) break;
                if (charArray[i] != charArray[r]) {
                    dp[i][r] = false;
                } else {
                    if (r - i < 3) {
                        dp[i][r] = true;
                    } else {
                        dp[i][r] = dp[i + 1][r - 1];
                    }
                }
                // 更新最长回文长度
                if (dp[i][r] && r - i + 1 > maxLen) {
                    maxLen = r - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
