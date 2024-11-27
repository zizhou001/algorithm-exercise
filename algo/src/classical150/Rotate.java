package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-27 10:54
 */
public class Rotate {

    public static void main(String[] args) {
        Rotate s = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        s.rotate(nums, 3);
        for (int e : nums){
            System.out.print(e + " ");
        }

    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int begin, int end){
        while (begin <= end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            ++begin;
            --end;
        }
    }
}
