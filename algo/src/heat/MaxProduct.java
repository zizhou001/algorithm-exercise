package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-22 9:38
 */
public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct s = new MaxProduct();
        System.out.println(s.maxProduct13(new int[]{2, -1, 1, 1}));
    }

    public int maxProduct13(int[] nums) {
        if (nums.length == 0) return 0;
        int maxProd = nums[0];
        int minProd = nums[0];  // 存储当前最小乘积
        int result = nums[0];   // 存储最终结果

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // 如果当前值是负数，交换当前最大和最小乘积
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // 更新最大和最小乘积
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            // 更新最终结果
            result = Math.max(result, maxProd);
        }

        return result;
    }

    public int maxProduct12(int[] nums) {
        int max = nums[0];
        int j = 0;
        int count = 1;
        while (j < nums.length) {
            count = nums[j] * count;
            max = Math.max(max, count);
            if (nums[j] == 0) {
                count = 1;
            }
            j++;
        }
        j = nums.length - 1;
        count = 1;
        while (j >= 0) {
            count = nums[j] * count;
            max = Math.max(max, count);
            if (nums[j] == 0) {
                count = 1;
            }
            j--;
        }
        return max;
    }

    public int maxProduct11(int[] nums) {
        long maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            long mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            if (minF < -1 << 31) {
                minF = nums[i];
            }
            ans = Math.max((int) maxF, ans);
        }

        return ans;

    }

    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public int maxProduct0(int[] nums) {
        if (nums == null) return 0;
        int length = nums.length;
        if (length == 1) return nums[0];
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = nums[i];
            if (dp[i - 1] != 0) {
                dp[i] *= dp[i - 1];
            }
            max = Math.max(max, dp[i]);
            for (int j = i - 1; j >= 0 && dp[j] != 0; j--) {
                max = Math.max(max, dp[i] / dp[j]);
            }
        }
        return max;
    }
}
