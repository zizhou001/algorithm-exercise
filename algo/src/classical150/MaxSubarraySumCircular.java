package classical150;

import heat100.MaxSubArray;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-06 11:17
 */
public class MaxSubarraySumCircular {

    public static void main(String[] args) {


    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];

        leftMax[0] = nums[0];
        int leftSum = nums[0];
        int pre = nums[0];
        int ans = nums[0];

        for(int i = 1; i < n; ++i){
            /**
             * @see MaxSubArray#maxSubArray(int[])
             */
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);

            // 有环的情况，第一部分，0到i，从左边遍历
            leftSum += nums[i];
            leftMax[i] = Math.max(leftSum, leftMax[i - 1]);
        }

        int rightSum = 0;
        for(int i = n - 1; i > 0; i--){
            // 有环的情况，第二部分，j到n-1，从右边遍历
            rightSum += nums[i];
            ans = Math.max(ans, rightSum + leftMax[i - 1]);
        }

        return ans;
    }
}
