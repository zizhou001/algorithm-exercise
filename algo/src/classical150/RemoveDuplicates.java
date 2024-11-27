package classical150;

import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-27 10:21
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates s = new RemoveDuplicates();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(s.removeDuplicates(nums));
        for (int e : nums) {
            System.out.print(e + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int targetIdx = 1;
        int curNum = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] != curNum){
                nums[targetIdx] = nums[i];
                curNum = nums[i];
                ++targetIdx;
            }
        }
        return targetIdx;
    }
}
