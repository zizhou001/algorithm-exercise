package heat;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-21 10:56
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange s = new CoinChange();
        System.out.println(s.coinChange(new int[]{2, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; j++) {
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
