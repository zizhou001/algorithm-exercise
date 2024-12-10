package classical150;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-10 11:16
 */
public class InsertInterval {


    public static void main(String[] args) {
        InsertInterval s = new InsertInterval();
        int[][] intervals = {{1,3},{6,9}};
        int[] newIntervals = {2,5};
        int[][] ans = s.insert(intervals, newIntervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("[" + ans[i][0] + "," + ans[i][1] + "]");
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        List<int[]> list = new ArrayList<>();
        if(N == 0){
            list.add(newInterval);
            return list.toArray(new int[1][]);
        }

        int left = 0, right = 0;

        // 1.先找新插入区间的left，同时保存不受影响的区间
        int i = 0;
        while(i < N){
            if(newInterval[0] < intervals[i][0]){
                left = newInterval[0];
                break;
            }else if(newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]){
                left = intervals[i][0];
                break;
            }else{
                list.add(intervals[i]);
                ++i;
            }
        }

        if(i >= N){
            list.add(newInterval);
            return list.toArray(new int[N+1][]);
        }

        // 2.再找新插入区间的right
        int j = i;
        boolean inMid = false;
        while(j < N){
            if(newInterval[1] < intervals[j][0]){
                right = newInterval[1];
                break;
            }else if(newInterval[1] >= intervals[j][0] && newInterval[1] <= intervals[j][1]){
                right = intervals[j][1];
                inMid = true;
                break;
            }else{
                ++j;
            }
        }

        if(j >= N){
            list.add(new int[]{left, newInterval[1]});
            return list.toArray(new int[list.size()][]);
        }

        // 3.插入新区间[left,right]
        list.add(new int[]{left, right});

        // 4.插入剩余的不受影响的区间
        int k = inMid ? j + 1 : j;
        while(k < N){
            list.add(intervals[k++]);
        }

        return list.toArray(new int[list.size()][]);
    }
}
