package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-25 15:11
 */
public class MinDistance {


    public static void main(String[] args) {
        MinDistance s = new MinDistance();
        System.out.println(s.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] 表示将word1[0,i]变为word2[0,j]所需要的最少操作次数
        int[][] dp = new int[m + 1][n + 1];

        // word2 为空，操作全部是删除
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }

        // word1 为空，操作全部是插入
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int appendWord2 = dp[i][j - 1] + 1;
                int appendWord1 = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    replace += 1;
                }
                dp[i][j] = Math.min(replace, Math.min(appendWord1, appendWord2));
            }
        }
        return dp[m][n];
    }
}
