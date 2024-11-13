package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-13 10:56
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l <= r){
            mid = (l + r) / 2;
            if (target == nums[mid]) return mid;
            else if (target >= nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
