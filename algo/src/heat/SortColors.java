package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-26 8:45
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 使用指针分别标记0的存放位置和2的存放位置
     * 遍历数组，通过交换的方式放到合适位置
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int length = nums.length;
        int p0 = 0, p2 = length - 1;
        for (int i = 0; i <= p2; i++) {
            while (i < p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
