package nk;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-15 10:35
 * @since JDK 17
 */
public class FindPeakElement {


    public static int fun(int[] nums){

        if(nums.length == 1) return 0;
        int pre, next = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                pre = -Integer.MAX_VALUE;
            }else pre = nums[i-1];
            if (i + 1 == nums.length) {
                next = -Integer.MAX_VALUE;
            }else next = nums[i+1];
            if (nums[i] > pre && nums[i] > next) return i;
        }
        return -1;

    }

    /**
     * 使用二分法解题
     * @param nums
     * @return
     */
    public static int fun2(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right){
            mid = (left + right) >> 1;
            if (mid > nums[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,2,7,8,4};
        System.out.println(fun2(nums));
        return;
    }
}
