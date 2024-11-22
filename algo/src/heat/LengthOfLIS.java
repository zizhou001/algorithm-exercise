package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-22 9:01
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS s = new LengthOfLIS();
        System.out.println(s.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int length = nums.length;
        if (length == 1) return 1;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
