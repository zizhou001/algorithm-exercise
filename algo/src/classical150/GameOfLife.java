package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-05 11:06
 */
public class GameOfLife {

    public static void main(String[] args) {
        GameOfLife s = new GameOfLife();
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        s.gameOfLife(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        // 跳过自身，避免重复计数
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    public void gameOfLife1(int[][] board) {
        int rLen = board.length, cLen = board[0].length;
        int[][] ans = new int[rLen][cLen];

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                int count = countLiveCells(board, i, j);
                if (board[i][j] == 1){
                    if (count < 2){
                        ans[i][j] = 0;
                    }else if (count == 2 || count == 3){
                        ans[i][j] = 1;
                    }else {
                        ans[i][j] = 0;
                    }
                }else if (board[i][j] == 0 && count == 3){
                    ans[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    private int countLiveCells(int[][] board, int r, int c) {
        int rLen = board.length, cLen = board[0].length;
        int count = 0;
        count = r - 1 >= 0 && board[r - 1][c] == 1 ? count + 1 : count;
        count = c - 1 >= 0 && board[r][c - 1] == 1 ? count + 1 : count;
        count = r - 1 >= 0 && c - 1 >= 0 && board[r - 1][c - 1] == 1 ? count + 1 : count;
        count = r - 1 >= 0 && c + 1 < cLen && board[r - 1][c + 1] == 1 ? count + 1 : count;
        count = r + 1 < rLen && board[r + 1][c] == 1 ? count + 1 : count;
        count = c + 1 < cLen && board[r][c + 1] == 1 ? count + 1 : count;
        count = r + 1 < rLen && c + 1 < cLen && board[r + 1][c + 1] == 1 ? count + 1 : count;
        count = r + 1 < rLen && c - 1 >= 0 && board[r + 1][c - 1] == 1 ? count + 1 : count;
        return count;
    }
}
