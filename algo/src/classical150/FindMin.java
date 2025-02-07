package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-07 11:12
 */
public class FindMin {

    public int findMin(int[] nums) {

        int n = nums.length;

        // 未翻转则直接返回第一个元素
        if(n == 1 || nums[0] < nums[n - 1]){
            return nums[0];
        }

        int left = 0, right = n - 1;
        while(left < right){
            int mid = (left + right) / 2;

            if (nums[left] < nums[mid]){
                left = mid;
            }else{
                right = mid;
            }
        }

        return nums[left + 1];
    }
}
