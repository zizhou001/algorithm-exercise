package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-03 10:33
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        MinSubArrayLen s = new MinSubArrayLen();
        System.out.println(s.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int left = 0, right = 0;
        int ans = len + 1;

        while (right < len) {
            if (sum + nums[right] < target) {
                sum += nums[right];
                ++right;
            } else{
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                ++left;
            }
        }
        return ans > len ? 0 : ans;
    }
}
