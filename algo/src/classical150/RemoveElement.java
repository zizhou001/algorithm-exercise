package classical150;

import java.util.ArrayList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-27 9:22
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement s = new RemoveElement();
        int[] nums = {2,3,3};
        System.out.println(s.removeElement(nums, 3));
        for (int e : nums) {
            System.out.print(e + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int end = n - 1;
        int count = n;

        for (int i = 0; i < n && i <= end; i++) {
            if (i == end){
                if (nums[i] == val) return --count;
                else return count;
            }
            if (nums[i] == val) {
                --count;
                while (end > i && nums[end] == val) {
                    --end;
                    --count;
                }
                if (end < i) return count;
                swap(nums, i, end);
                --end;
            }
        }
        return count;
    }

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
