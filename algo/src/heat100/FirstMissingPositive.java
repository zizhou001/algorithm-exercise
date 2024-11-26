package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-28 16:21
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {3, 1, 4, 5};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }

    /**
     * 思想：
     * 1. 考察1到N是否都存在数组中
     * 2. 若i存在，将第i个元素标记为负数；i+1存在，将第i+1个元素标记为负数……
     * 3. 找出第一个不是负数的索引x————说明值x不存在
     * 思路：
     * 1. 对于长度为N的数组，若数组为 {1,2,3,...,4,N},则 ans=N+1
     * 2. 1到 N之间任意缺失的第一个正数即为ans，故只需要关注nums[i]在[1,N]的元素
     * 3. 核心问题：如何表示、标记连续且唯一的数列
     * 4. 处理过程：
     *      1）将负数置为不相干值：nums[i]=N+1
     *      2) 模仿哈希的原理，对已经出现的**有效元素**,标记其值对应的**索引**。
     *          例如 N=5，若发现一个元素3，则将数组中第三个元素 nums[3-1] 标记为负数。
     *      3） 若原数组为{3,5,2,1,4},则按照上述索引标记规则，所有元素均为负数，ans=N+1
     *          若原数组为{3,5,-3,1,4}，缺失2，则数组中第1个元素为负，第2个为正，第3个为负，……
     *          第一个为正的元素是第2个元素，说明原数组中2缺失。
     * 特点：
     * 1. N 与 nums[i] 密切相关
     * 2. 顺序，二值标记(true or false)
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
