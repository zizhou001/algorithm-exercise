package heat;

import utils.ArrayPrinter;

import java.util.Arrays;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-29 8:51
 */
public class SetZeroes {

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes.setZeroes(matrix);
        ArrayPrinter.print2DArray(matrix);
    }

    public void setZeroes(int[][] matrix) {

        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (row[i] == 1){
                Arrays.fill(matrix[i], 0);
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (col[j] == 1) matrix[i][j] = 0;
            }
        }
    }
}
