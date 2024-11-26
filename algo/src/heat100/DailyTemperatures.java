package heat100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-18 11:20
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures s = new DailyTemperatures();
        int[] res = s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        if (len == 1) return ans;
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while (!stk.isEmpty() && temperature > temperatures[stk.peek()]){
                int preIdx = stk.pop();
                ans[preIdx] = i - preIdx;
            }
            stk.push(i);
        }
        return ans;
    }
}
