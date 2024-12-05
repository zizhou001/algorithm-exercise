package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-05 9:53
 */
public class SetZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        SetZeroes s = new SetZeroes();
        s.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 用 matrix[0][j] 记录每一列是否存在0（不含第一列）
     * 用 matrix[i][0] 记录每一行是否存在0（不含第一行）
     * 特别的，用两个临时变量记录第一列和第一行的含零情况
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rLen = matrix.length, cLen = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        // 检查第一列
        for (int i = 0; i < rLen; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        // 检查第一行
        for (int j = 0; j < cLen; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        // 检查其他部分，并记录
        for (int i = 1; i < rLen; i++) {
            for (int j = 1; j < cLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 填充其他部分
        for (int i = 1; i < rLen; i++) {
            for (int j = 1; j < cLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后填充第一列和第一行
        if (flagCol0) {
            for (int i = 0; i < rLen; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < cLen; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
