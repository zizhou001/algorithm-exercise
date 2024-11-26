package heat100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 当我们需要枚举数组中的两个元素时，
 * 如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法，
 *
 * 关键点：
 *  1. 先排序
 *  2. 第三个数字c从后往前找
 *  3. 不重复找
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-23 15:37
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> arrayLists = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first-1]) continue;
            int third = len - 1;
            int target = -nums[first];
            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second-1]) continue;
                while (second < third && nums[second] + nums[third] > target) third--;
                if (second == third) break;
                if (nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    arrayLists.add(list);
                }
            }
        }
        return arrayLists;
    }
}
