package heat;

import utils.ArrayPrinter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-29 9:57
 */
public class RotateMatrix {

    public static void main(String[] args) {
        // ArrayPrinter.print2DArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[][] matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        new RotateMatrix().rotate(matrix);
        ArrayPrinter.print2DArray(matrix);
    }

    public Deque<Integer> getOrPut(int[][] matrix, int direction, int left, int right, int top, int bottom,
                                    Deque<Integer> deque,
                                    boolean isPut) {
        int count = (right - left + 1) * (right - left + 1) - (right - left - 1) * (right - left - 1);
        if (!isPut) deque.clear();

        while (count > 0) {
            switch (direction) {
                case 0: {
                    for (int j = left; j <= right; j++) {
                        if (!isPut) deque.add(matrix[top][j]);
                        else matrix[top][j] = deque.poll().intValue();
                        count--;
                    }
                    top++;
                    direction = 1;
                    break;
                }
                case 1: {
                    for (int i = top; i <= bottom; i++) {
                        if (!isPut) deque.add(matrix[i][right]);
                        else matrix[i][right] = deque.poll().intValue();
                        count--;
                    }
                    right--;
                    direction = 2;
                    break;
                }
                case 2: {
                    for (int j = right; j >= left; j--) {
                        if (!isPut) deque.add(matrix[bottom][j]);
                        else matrix[bottom][j] = deque.poll().intValue();
                        count--;
                    }
                    bottom--;
                    direction = 3;
                    break;
                }
                case 3: {
                    for (int i = bottom; i >= top; i--) {
                        if (!isPut) deque.add(matrix[i][left]);
                        else matrix[i][left] = deque.poll().intValue();
                        count--;
                    }
                    left++;
                    direction = 0;
                    break;
                }
            }
        }
        if (!isPut) return deque;
        else return null;
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        Deque<Integer> circleVal = new ArrayDeque<>();
        while (true) {
            circleVal = getOrPut(matrix, 0, left, right, top, bottom, circleVal,
                    false);
            if (circleVal.isEmpty()) return;
            getOrPut(matrix, 1, left++, right--, top++, bottom--, circleVal,
                    true);
        }
    }
}
