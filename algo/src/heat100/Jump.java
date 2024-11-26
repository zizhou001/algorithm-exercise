package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-20 10:14
 */
public class Jump {

    int count = 0;

    public static void main(String[] args) {
        Jump s = new Jump();
        System.out.println(s.jump2(new int[]{1, 1, 1, 1}));
    }

    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        pd(nums, 0);
        return count;
    }

    public void pd(int[] nums, int pos) {
        // 获取当前位置所能考虑的最远位置边界
        int examinableBound = nums[pos] + pos;

        int nextPos = pos;
        if (examinableBound >= nums.length - 1) {
            count++;
            return;
        }
        // 临时变量作为循环退出条件
        int bound = examinableBound;

        // 在可检查范围内，寻找能跳的最远的下一跳位置
        for (int i = pos + 1; i <= bound; i++) {
            if (nums[i] + i > examinableBound) {
                // 更新可检查范围
                examinableBound = nums[i] + i;
                // 记录下一跳位置
                nextPos = i;
            }
        }
        // 跳到下一个位置，次数+1
        count++;
        pd(nums, nextPos);
    }

    public int jump1(int[] nums) {
        int steps = 0;
        int farthestReachablePos = 0;
        int length = nums.length;
        int examinablePosBound = 0;
        for (int i = 0; i < length - 1; i++) {
            System.out.println(nums[i] + i);
            farthestReachablePos = Math.max(farthestReachablePos, nums[i] + i);
            if (i == examinablePosBound) {
                examinablePosBound = farthestReachablePos;
                ++steps;
            }
        }
        return steps;
    }
}
