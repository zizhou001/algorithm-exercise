package heat100;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-13 9:09
 */
public class SolveNQueens {

    Set<Integer> columns = new HashSet<>();
    Set<Integer> primary = new HashSet<>();
    Set<Integer> secondary = new HashSet<>();

    List<List<String>> solutions = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(n, 0, queens);
        return solutions;
    }

    public void backtrack(int n, int row, int[] queens){
        if (row == n){
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        }else{
            for (int col = 0; col < n; col++) {
                if (columns.contains(col)){
                    continue;
                }
                int p = row - col;
                if (primary.contains(p)){
                    continue;
                }
                int s = row + col;
                if (secondary.contains(s)){
                    continue;
                }

                queens[row] = col;
                columns.add(col);
                primary.add(p);
                secondary.add(s);
                backtrack(n, row + 1, queens);
                secondary.remove(s);
                primary.remove(p);
                columns.remove(col);
                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
