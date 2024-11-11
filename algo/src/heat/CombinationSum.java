package heat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-11 15:33
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        List<List<Integer>> lists = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        backtrack(candidates, target, ans, combine, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx){
        if (idx == candidates.length){
            return;
        }
        if (target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 右子树，不选择当前数字，target不变考虑下一个数字
        backtrack(candidates, target, ans, combine, idx + 1);

        // 左子树，选择当前数字，target -= candidates[idx]
        if (target - candidates[idx] >= 0){
            combine.add(candidates[idx]);
            backtrack(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size()- 1);
        }
    }

}
