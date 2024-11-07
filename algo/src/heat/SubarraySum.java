package heat;

import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-25 8:31
 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    /**
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 前缀为0的情况，出现了一次
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            // 若pre-k存在，说明之前在某个点j的累积和是pre-k
            // 而当前点i的累计和是pre，则sum[j,i]=pre-(pre-k)=k
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            // 否则，存储这个新的pre值
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    /**
     * 通过，使用枚举
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {

        int n = nums.length;
        int res = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }

        return res;
    }
}
