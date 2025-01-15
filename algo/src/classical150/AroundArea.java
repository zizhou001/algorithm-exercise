package classical150;

import heat100.NumIslands;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-01-07 10:39
 */
public class AroundArea {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        AroundArea s = new AroundArea();
        s.solve(board);
    }

    public void solve(char[][] board) {
        int nr = board.length;
        int nc = board[0].length;

        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++){
                if((r == 0 || c == 0 || r == nr - 1 || c == nc - 1) && board[r][c] == 'O'){
                    dfs(board, r, c);
                }
            }
        }

        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] board, int r, int c){
        int nr = board.length;
        int nc = board[0].length;

        if(r < 0 || r >= nr  || c < 0 || c >= nc || board[r][c] == 'X' || board[r][c] == 'T'){
            return;
        }

        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
