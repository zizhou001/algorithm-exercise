package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-28 9:11
 */
public class CJ {

    public static void main(String[] args) {
        CJ s = new CJ();
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        int longest = nums[0];
        int length = nums.length;
        int[] j = new int[length];
        for (int i = 0; i < length; i++) {
            if (longest >= i){
                j[i] = nums[i] + i;
                longest = Math.max(longest, j[i]);
            }
            if (longest >= length - 1) return true;
        }
        return false;
    }
}
