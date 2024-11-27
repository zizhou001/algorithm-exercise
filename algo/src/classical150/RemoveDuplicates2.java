package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-27 10:30
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        RemoveDuplicates2 s = new RemoveDuplicates2();
        int[] nums = {0, 1, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(s.removeDuplicates(nums));
        for (int e : nums) {
            System.out.print(e + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int curNum = nums[0];
        int p = 1;
        boolean ok = false;

        for (int i = 1; i < length; i++) {
            if (nums[i] == curNum) {
                if (!ok) {
                    nums[p] = curNum;
                    ok = true;
                    ++p;
                }
            } else{
                nums[p] = nums[i];
                curNum = nums[i];
                ++p;
                ok = false;
            }
        }

        return p;

    }
}
