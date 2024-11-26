package heat100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-28 9:11
 */
public class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals1 = {{1, 4}, {0, 2}, {3, 5}, {6, 9}, {7, 10}};
        int[][] intervals2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge.merge(intervals1);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        final int N = intervals.length;
        if (N == 1) return intervals;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0], right = intervals[0][1];
        map.put(left, right);
        for (int i = 1; i < N; i++) {
            if (intervals[i][0] >= left && intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
            map.put(left, right);
        }
        int[][] res = new int[map.size()][2];
        int j = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            res[j++] = new int[]{m.getKey(), m.getValue()};
        }
        return res;
    }
}
