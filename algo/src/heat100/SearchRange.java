package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-13 11:15
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        int[] res = s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res[0] + "," + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid  = 0;
        int[] ans = new int[]{-1, -1};
        while(l <= r){
            mid = (l + r) / 2;
            if(target == nums[mid]) {
                int i = mid;
                while (i >= 0 && nums[i] == target){
                    ans[0] = i--;
                }
                i = mid;
                while (i < nums.length && nums[i] == target){
                    ans[1] = i++;
                }
                return ans;
            }else if(target > nums[mid]) l = mid + 1;
            else r = mid  - 1;
        }
        return ans;
    }
}
