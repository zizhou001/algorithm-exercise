package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-21 9:08
 */
public class Rob {

    public static void main(String[] args) {
        Rob s = new Rob();
        System.out.println(s.rob(new int[]{1,2,3,1}));
    }

    public int rob(int[] nums) {
        if (nums == null) return 0;
        int length = nums.length;
        if (length == 1) return nums[0];
        int ans = 0;
        int[] m = new int[length];
        m[0] = nums[0];
        m[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            m[i] = Math.max(m[i - 2] + nums[i], m[i - 1]);
        }
        return m[length - 1];
    }
}
