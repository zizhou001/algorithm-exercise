package heat;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-07 16:37
 */
public class OrangesRotting {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}};
        OrangesRotting s = new OrangesRotting();
        System.out.println(s.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        final int R = grid.length;
        final int C = grid[0].length;
        // 依次代表上，左，下，右
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> orangeStatusMap = new HashMap<>();
        // 记录初始情况下（第0秒）所有腐烂的橘子
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int curOrange = r * C + c;
                    queue.add(curOrange);
                    orangeStatusMap.put(curOrange, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            // 考虑当前已经腐烂的橘子
            Integer curRottedOrange = queue.poll();
            int r = curRottedOrange / C, c = curRottedOrange % C;
            // 向四个方向腐烂
            for (int k = 0; k < 4; k++) {
                int toRotOrangeRowIdx = r + dr[k];
                int toRotOrangeColIdx = c + dc[k];
                // 当索引不越界且存在新鲜橘子时
                if (toRotOrangeRowIdx >= 0 && toRotOrangeRowIdx < R
                        && toRotOrangeColIdx >= 0 && toRotOrangeColIdx < C
                        && grid[toRotOrangeRowIdx][toRotOrangeColIdx] == 1) {
                    // 产生新腐烂的橘子
                    grid[toRotOrangeRowIdx][toRotOrangeColIdx] = 2;
                    // 添加到队列中
                    int newRottedOrangeIdx = toRotOrangeRowIdx * C + toRotOrangeColIdx;
                    queue.add(newRottedOrangeIdx);
                    // 记录新腐烂的橘子的产生时间 = 源腐烂橘子腐烂时间 + 1
                    orangeStatusMap.put(newRottedOrangeIdx, orangeStatusMap.get(curRottedOrange) + 1);
                    // 更新结果
                    ans = orangeStatusMap.get(newRottedOrangeIdx);
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) return -1;
            }
        }
        return ans;
    }
}
