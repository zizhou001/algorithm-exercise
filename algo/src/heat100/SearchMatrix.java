package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-30 9:01
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 3}};
        int target = 5;
        System.out.println(new SearchMatrix().searchMatrix(matrix, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int col = m - 1, row = 0;
        while (col >= 0 && row < n){
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) row++;
            else col--;
        }
        return false;
    }

}
