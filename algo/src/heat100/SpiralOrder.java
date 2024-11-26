package heat100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-29 9:12
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = new SpiralOrder().spiralOrder(matrix);
        for (int e : res) {
            System.out.print(e + " ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int direction = 0;

        while (ans.size() < m * n) {
            switch (direction) {
                case 0: {
                    for (int j = left; j <= right; j++) {
                        ans.add(matrix[top][j]);
                    }
                    top++;
                    direction = 1;
                    break;
                }
                case 1: {
                    for (int i = top; i <= bottom; i++) {
                        ans.add(matrix[i][right]);
                    }
                    right--;
                    direction = 2;
                    break;
                }
                case 2: {
                    for (int j = right; j >= left; j--) {
                        ans.add(matrix[bottom][j]);
                    }
                    bottom--;
                    direction = 3;
                    break;
                }
                case 3: {
                    for (int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++;
                    direction = 0;
                    break;
                }
            }
        }
        return ans;
    }
}
