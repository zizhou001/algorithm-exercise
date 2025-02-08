package classical150;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-08 9:45
 */
public class FindMaximizedCapital {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
        int n = profits.length;

        // 记录某个项目的  启动资金-利润
        int[][] map = new int[n][2];

        // 初始化map
        for (int i = 0; i < n; i++) {
            map[i][0] = capital[i];
            map[i][1] = profits[i];
        }

        // 按照启动资金，从小到大排序
        Arrays.sort(map,(a, b) -> a[0] - b[0]);

        // 用于遍历map
        int idx = 0;

        // 从大到小记录利润
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        for (int i = 0; i < k; i++) {

            while (idx < n && map[idx][0] <= w){
                // 将利润加入到优先队列中
                pq.offer(map[idx++][1]);
            }

            if(!pq.isEmpty()){
                w += pq.poll();
            }else{
                break;
            }
        }

        return w;
    }
}
