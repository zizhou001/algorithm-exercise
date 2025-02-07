package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-07 10:08
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
