package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-28 10:15
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1,-100,3,99};
        int k1 = 3;
        Rotate rotate = new Rotate();
        rotate.rotate(nums1, k1);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
