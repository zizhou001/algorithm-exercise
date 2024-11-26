package heat100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-18 14:54
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        LargestRectangleArea s = new LargestRectangleArea();
        System.out.println(s.largestRectangleArea22(new int[]{2, 1, 5, 6, 2, 3}));
    }

    /**
     * 哨兵机制
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea22(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        int area = 0;
        int[] newHeights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newHeights[i + 1] = heights[i];
        }
        n += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < n; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }

    /**
     * 遍历所有柱子，对于柱子i：
     * - 若柱子高于栈顶柱子高度，入栈
     * - 若柱子低于栈顶柱子高度，出栈
     * - 宽度为 i - peek - 1
     * - 高度为 height[i]
     * 遍历完成后，继续考虑栈中的元素，依次出栈
     * - 出栈后为栈不空，则该高度对应的宽度为 n - peek - 1
     * - 出栈后栈为空，则该高度对应的最大宽度为 i- 1
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea21(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        int area = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int height = heights[stack.removeLast()];

                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }
            int width;
            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peekLast() - 1;
            }
            area = Math.max(area, width * height);
        }
        return area;
    }

    /**
     * 固定高度，寻找符合要求的最长底边
     * 对于某一根柱子 i，高度为 h
     * 1）左边界l：左边第一个比他低的
     * 2）右边界r：右边第一个比他低的
     * 对于柱子i，其能构造的最大面积为 (r - l - 1 ) * h
     * 利用单调栈，将每个柱子的左，右边界保存。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < length; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
