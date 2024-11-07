package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-28 15:58
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf.productExceptSelf(nums);
        for (int e : res) System.out.println(e);
    }

    public int[] productExceptSelf(int[] nums) {

        final int N = nums.length;

        int[] ans = new int[N];

        int[] pre = new int[N];

        int[] after = new int[N];

        pre[0] = nums[0];
        for (int i = 1; i < N; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        after[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            after[i] = after[i + 1] * nums[i];
        }

        ans[0] = after[1];
        ans[N - 1] = pre[N - 2];
        for (int i = 1; i < N - 1; i++) {
            ans[i] = pre[i - 1] * after[i + 1];
        }

        return ans;
    }
}
