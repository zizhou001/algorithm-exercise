package heat100;

import java.util.HashSet;
import java.util.Set;

/**
 * 关键点：
 *  1. 放入set，去重
 *  2. 遍历数组一次
 *  3. 迭代寻找对于当前数字curNum， contains(curNum+1)？？
 *     并且记录长度
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-22 9:51
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(solution(arr));
    }

    public static int solution(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> st = new HashSet<>();
        int ans = 0;
        for(int num : nums) {
            st.add(num);
        }

        for(int x : st) {
            if(st.contains(x-1)) continue;
            int y = x + 1;
            while(st.contains(y)) {
                y += 1;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }
}
