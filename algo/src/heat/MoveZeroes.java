package heat;

/**
 * 关键点：
 * 1. 顺序遍历一次
 * 2. 一个指针指向0（即将被非0覆盖），另一个指针指向非0
 * 3. 非0覆盖0（赋值）
 * 4. 0覆盖在数组末尾
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-22 10:28
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        solution(nums);
        for (int num : nums) System.out.println(num);
    }

    public static void solution(int[] nums) {

        int toBePutIdx = 0;
        int n = nums.length;
        for (int nonZeroIdx = 0; nonZeroIdx < n; nonZeroIdx++) {
            if (nums[nonZeroIdx] != 0) {
                nums[toBePutIdx] = nums[nonZeroIdx];
                toBePutIdx++;
            }
        }
        while (toBePutIdx < n) nums[toBePutIdx++] = 0;
    }


}
