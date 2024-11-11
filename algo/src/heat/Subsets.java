package heat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-11 11:14
 */
public class Subsets {

    List<List<Integer>> res;
    int n = 0;
    int[] selected;

    public static void main(String[] args) {
        Subsets s = new Subsets();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
        subsets.forEach(System.out::println);
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        selected = new int[n];
        dfs(0, nums);
        return res;
    }

    void dfs(int t, int[] nums) {
        if (t == n) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i] == 1) list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        selected[t] = 0;
        dfs(t + 1, nums);
        selected[t] = 1;
        dfs(t + 1, nums);
    }
}
