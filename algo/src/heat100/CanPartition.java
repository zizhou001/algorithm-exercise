package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-22 11:10
 */
public class CanPartition {

    public static void main(String[] args) {
        CanPartition s = new CanPartition();
        System.out.println(s.canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length == 1) return false;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
