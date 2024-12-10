package classical150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-10 11:57
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        FindMinArrowShots s = new FindMinArrowShots();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(s.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] point1, int[] point2) {
                // 注意：当两个数较大时，不能直接减，会溢出
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
