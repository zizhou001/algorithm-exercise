package heat;

/**
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-28 8:17
 */
public class MaxSubArray {



    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));

    }

    /**
     * 动态规划：
     * f(i)代表数组中以nums[i]结束的最大和。
     * 即：f(i) 应该为 max{f(i)+nums[i], nums[i]}
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int pre = 0;
        int res = nums[0];
        for (int i = 0; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
        }
        return res;
    }
}
