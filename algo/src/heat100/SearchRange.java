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
        int begin = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);

        return new int[]{begin, end};
    }

    public int binarySearch(int[] nums, int target, boolean isBegin){
        int n = nums.length;
        int bound = -1;

        int left = 0, right = n - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                bound = mid;
                if(isBegin){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return bound;
    }
}
