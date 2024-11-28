package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-28 11:09
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf s = new ProductExceptSelf();
        int[] ans = s.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int e : ans) {
            System.out.print(e + " ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int prefix = 1;
        int suffix = 1;

        int[] ans = new int[length];

        for (int i = 0; i < length; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = length - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }
}
