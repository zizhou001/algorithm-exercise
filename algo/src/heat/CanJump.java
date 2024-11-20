package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-20 8:47
 */
public class CanJump {


    public static void main(String[] args) {
        CanJump s = new CanJump();
        System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 记录每个位置的最远可达
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int farthestReachablePos = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > farthestReachablePos) return false;
            farthestReachablePos = Math.max(farthestReachablePos, nums[i] + i);
            if (farthestReachablePos >= length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 复杂
     *
     * @param nums
     * @return
     */
    public boolean canJump0(int[] nums) {
        int length = nums.length;
        if (length == 1) return true;
        int curPos = 0;
        while (curPos < length - 1) {
            int possibleMaxSteps = nums[curPos];
            if (possibleMaxSteps == 0) return false;
            int i = curPos + 1;
            int nextPos = curPos;
            int nextMaxJumpStep = Integer.MIN_VALUE;
            while (i <= curPos + possibleMaxSteps) {
                if (i >= length - 1) return true;
                if (nums[i] >= nextMaxJumpStep) {
                    nextMaxJumpStep = nums[i];
                    nextPos = i;
                }
                ++i;
            }
            if (nextPos + nextMaxJumpStep > curPos + possibleMaxSteps + nums[curPos + possibleMaxSteps]) {
                curPos = nextPos;
            } else {
                curPos += possibleMaxSteps;
            }
        }
        return true;
    }
}
