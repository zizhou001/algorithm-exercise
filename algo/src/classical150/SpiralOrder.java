package classical150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-05 9:16
 */
public class SpiralOrder {

    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> ans = s.spiralOrder(matrix);
        System.out.println(ans);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int right = cLen - 1, bottom = rLen - 1, left = 0, top = 0;
        int direction = 0;
        int count = 0;
        while (count < rLen * cLen) {
            switch (direction) {
                case 0: {
                    for (int i = left; i <= right; i++) {
                        ans.add(matrix[top][i]);
                        ++count;
                    }
                    ++top;
                    direction = 1;
                    break;
                }
                case 1: {
                    for (int i = top; i <= bottom; i++) {
                        ans.add(matrix[i][right]);
                        ++count;
                    }
                    --right;
                    direction = 2;
                    break;
                }
                case 2: {
                    for (int i = right; i >= left ; i--) {
                        ans.add(matrix[bottom][i]);
                        ++count;
                    }
                    --bottom;
                    direction = 3;
                    break;
                }
                case 3:{
                    for (int i = bottom; i >= top ; i--) {
                        ans.add(matrix[i][left]);
                        ++count;
                    }
                    ++left;
                    direction = 0;
                    break;
                }
            }
        }
        return ans;
    }
}
