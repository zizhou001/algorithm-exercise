package heat;

/**
 * 变量定义：
 * - a: 起点 到 环入口 步数
 * - b：环入口 到 相遇点 步数
 * <p>
 * fast走的距离：2(a+b)，也可以表示为 a + b + kL
 * slow走的距离  a+b
 * 2(a+b) = a + b + kL
 * 解得： a = (k − 1)L + (L − b) = (k − 1)L + c
 * 如果慢指针从起点出发，快指针从相遇位置出发，每次两个指针都移动一步，则慢指针走了 a 步之后到达环的入口
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-26 10:40
 */
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate s = new FindDuplicate();
        System.out.println(s.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
