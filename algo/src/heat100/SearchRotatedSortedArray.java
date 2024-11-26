package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-14 8:43
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[]{1, 3}, 4));
    }


    public int search(int[] nums, int target) {
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        int i = 0;
        while (i < nums.length) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                break;
            } else ++i;
        }
        int part1 = binarySearch(nums, 0, i >= nums.length ? nums.length - 1  : i, target);
        if (part1 != -1) return part1;
        return binarySearch(nums, i + 1 >= nums.length ? nums.length - 1  : i + 1, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) return m;
            else if (target > nums[m]) {
                l = m + 1;
            } else r = m - 1;
        }
        return -1;
    }
}
