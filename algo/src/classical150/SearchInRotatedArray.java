package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-07 10:23
 */
public class SearchInRotatedArray {

    /**
     * 1. mid分为两部分
     * 2. 若第一部分升序，在第一部分中二分查找，否则第二部分
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;

        if(n == 0){
            return -1;
        }

        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = n - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            }

            // 第一部分是有序的
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ // 第二部分是有序的
                if(target >= nums[mid] && target <= nums[n - 1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
