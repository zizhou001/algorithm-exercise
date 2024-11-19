package heat;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-19 9:15
 */
public class TopKFrequent {

    public static void main(String[] args) {
        TopKFrequent s = new TopKFrequent();
        int[] ans = s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return new int[]{nums[0]};
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>((o1, o2) -> -(o1.getValue() - o2.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            priorityQueue.offer(entry);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll().getKey().intValue();
        }
        return ans;
    }


}
