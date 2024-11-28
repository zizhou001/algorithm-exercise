package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-28 8:45
 */
public class MaxProfit2 {

    public static void main(String[] args) {
        MaxProfit2 s = new MaxProfit2();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(s.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int in = -1;
        int profit = 0;
        int length = prices.length;

        for (int i = 0; i < length; i++) {
            if (in == -1) {
                if (i + 1 < length && prices[i + 1] > prices[i]) {
                    in = prices[i];
                }
            }
            if (in != -1) {
                if (i + 1 < length && prices[i + 1] < prices[i]) {
                    profit += prices[i] - in;
                    in = -1;
                }
                if (i == length - 1){
                    profit += prices[i] - in;
                }
            }
        }
        return profit;
    }
}
