package classical150;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-08 10:20
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>(k, ((o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]]);
        }));

        for (int i = 0; i < Math.min(m, k); i++) {
            queue.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !queue.isEmpty()){
            int[] pair = queue.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[pair[0]]);
            list.add(nums2[pair[1]]);
            ans.add(list);
            if (pair[1] + 1 < n){
                queue.offer(new int[]{pair[0], pair[1] + 1});
            }
        }
        return ans;
    }
}
