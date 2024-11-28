package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-28 9:11
 */
public class CJ2 {

    public static void main(String[] args) {
        CJ2 s = new CJ2();
        System.out.println(s.canJump(new int[]{1, 3, 2}));
    }

    public int canJump(int[] nums) {
        int length = nums.length;
        int count = 0;
        int curPos = 0, nextPos = 0;
        int nextBound = 0, curBound = nums[0];

        if (length == 1) return 0;
        if (curBound >= length - 1) return 1;

        // 目的地还未包含在当前考察的范围
        while (curBound < length - 1) {
            // 在当前考察范围内寻找：1）下一跳位置 2）下个考察范围
            for (int i = curPos + 1; i <= curBound; i++) {
                if (nums[i] + i > nextBound) {
                    nextBound = nums[i] + i;
                    nextPos = i;
                }
            }
            // 跳一次，更新相关变量
            ++count;
            curPos = nextPos;
            curBound = nextBound;
        }
        // 还需要一跳就可以到达
        return ++count;
    }
}
