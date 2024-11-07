package nk;

/**
 * @author zizhou
 * @create 2024-04-08 19:54
 */
public class Search {

    public static int solution(int[] nums, int target){
        if (nums.length == 0) return -1;
        int mid = 0;
        int begin = 0, end = nums.length;
        while (begin <= end){
            mid = (end + begin) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                begin = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1};
        System.out.println(solution(nums, -1));
    }
}
