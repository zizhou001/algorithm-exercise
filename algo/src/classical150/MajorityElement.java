package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-27 10:42
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement s = new MajorityElement();
        System.out.println(s.majorityElement(new int[]{1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2}));
    }

    /**
     * 投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int curNum = nums[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == curNum) {
                ++count;
            } else {
                --count;
                if (count <= 0) {
                    curNum = nums[i];
                    count = 1;
                }
            }
        }
        return curNum;
    }
}
