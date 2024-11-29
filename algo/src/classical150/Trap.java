package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-29 17:31
 */
public class Trap {

    public static void main(String[] args) {
        Trap s = new Trap();
        System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;

        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            ans = ans + Math.min(left[i], right[i]) - height[i];
        }

        return ans;

    }
}
