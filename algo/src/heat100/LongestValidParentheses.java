package heat100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-22 12:05
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses s = new LongestValidParentheses();
        System.out.println(s.longestValidParentheses2("()(()"));
    }


    /**
     * 不需要额外空间
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLen;
    }

    /**
     * 使用栈
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s.isEmpty()) return 0;
        int length = s.length();
        int[] mark = new int[length];
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    mark[i] = 1;
                } else {
                    mark[i] = -1;
                }
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            mark[stack.pop()] = -1;
        }
        int count = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == -1) {
                max = Math.max(count * 2, max);
                count = 0;
            } else if (mark[i] == 1) {
                count++;
            }
        }
        max = Math.max(count * 2, max);
        return max;
    }
}
