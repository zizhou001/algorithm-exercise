package heat100;

import utils.BarChart;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-23 16:38
 */
public class Trap {

    public static void main(String[] args) {
        int[] height0 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height1 = {4, 2, 0, 3, 2, 5};
        int[] height2 = {4, 2, 3};
        int[] height3 = {5, 5, 1, 7, 1, 1, 5, 2, 7, 6};
        int[] height4 = {5, 4, 1, 2};
        System.out.println(trap2(height0));
    }

    /**
     * 通过，但耗时和内存较高
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        new BarChart(height).draw();
        int length = height.length;
        int save = 0;
        int slow = 0, fast = 1;
        while (fast < length - 1) {
            if (height[slow] <= height[fast]) {
                slow++;
                fast++;
            } else {
                int leftBound = height[slow];
                boolean find = false;
                int highestRightBound = height[fast];
                int nextRightBound = -1;
                int targetRightBoundIdx = -1;
                while (fast < length) {
                    if (height[fast] > leftBound) {
                        find = true;
                        nextRightBound = height[fast];
                        targetRightBoundIdx = fast;
                        break;
                    }
                    if (height[fast] >= highestRightBound) {
                        highestRightBound = height[fast];
                        find = true;
                        targetRightBoundIdx = fast;
                    }
                    fast++;
                }
                int targetRightBound = nextRightBound != -1 ? nextRightBound : highestRightBound;
                if (!find || targetRightBoundIdx - slow == 1) {
                    slow = slow + 1;
                    fast = slow + 1;
                } else {
                    fast = targetRightBoundIdx;
                    int bound = Math.min(leftBound, targetRightBound);
                    while (slow != fast - 1) {
                        slow++;
                        save += bound - height[slow];
                    }
                }
            }
        }
        return save;
    }


    /**
     * 使用动态规划：
     * 思路，每个索引位置i能容纳的水量save[i] = min{左边最高，右边最高} - height[i]
     * 但是，若对于每个i，分别向左和向右扫描，复杂度为 O(n^2)
     * 因为，有如下关系
     * leftMax[i] = max(leftMax[i-1], height[i]), 1 <= i <= n-1
     * rightMax[i] = max(rightMax[i+1], height[i]), 0 <= i <= n-2
     * 所以，可以使用动态规划
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        new BarChart(height).draw();

        int n = height.length;

        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int save = 0;
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i <= n - 1; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; ++i) {
            save += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return save;
    }
}
