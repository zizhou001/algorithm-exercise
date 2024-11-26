package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-14 9:16
 */
public class SearchMinInRotatedSorted {

    public static void main(String[] args) {
        SearchMinInRotatedSorted s = new SearchMinInRotatedSorted();
        System.out.println(s.findMin(new int[]{3,4,5,1,2}));
    }

    public int findMin(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                break;
            } else ++i;
        }
        if (i == nums.length) return nums[0];
        else return nums[i + 1];
    }
}
