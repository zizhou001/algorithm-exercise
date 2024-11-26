package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-20 8:24
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit s = new MaxProfit();
        System.out.println(s.maxProfit(new int[]{2, 1, 4}));
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            } else if (prices[i] - minBuyPrice > maxProfit){
                maxProfit = prices[i] - minBuyPrice;
            }
        }
        return maxProfit;
    }
}
