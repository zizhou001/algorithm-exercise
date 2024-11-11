package heat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-11 10:11
 */
public class Permute {

    int n = 0;
    ArrayList<List<Integer>> res;

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> res = permute.permute(new int[]{1, 2, 3});
        res.stream().forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        backtrack(0, nums);
        return res;
    }

    void backtrack(int t, int[] nums) {
        if (t == n) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            res.add(list);
        }
        for (int i = t; i < n; i++) {
            swap(nums, i, t);
            backtrack(t + 1, nums);
            swap(nums, t, i);
        }
    }

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
