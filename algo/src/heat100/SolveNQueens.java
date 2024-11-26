package heat100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-13 9:09
 */
public class SolveNQueens {

    List<List<String>> ans;
    int queenNum;
    int[][] put;

    public static void main(String[] args) {
        SolveNQueens s = new SolveNQueens();
        List<List<String>> lists = s.solveNQueens(5);
        lists.forEach(System.out::println);
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        if (n == 1) {
            ans.add(new ArrayList<>(Arrays.asList("Q")));
            return ans;
        }
        queenNum = n;
        put = new int[n][n];
        backtrack(0, 0, initializeStringBufferWithDots(queenNum), new ArrayList<>());
        return ans;
    }

    public void backtrack(int row, int col, StringBuffer line, List<String> plan) {
        if (row == queenNum) {
            ans.add(new ArrayList<>(plan));
            return;
        }
        for (int j = col; j < queenNum; j++) {
            if (check(row, j)) {
                put[row][j] = 1;
                line.setCharAt(j, 'Q');
                plan.add(line.toString());
                backtrack(row + 1, 0, initializeStringBufferWithDots(queenNum), plan);
                plan.remove(plan.size() - 1);
                put[row][j] = 0;
                line.setCharAt(j, '.');
            }
        }
    }

    public boolean check(int row, int col) {

        if (row == 0) return true;

        // 检查同一列是否有棋子
        for (int i = 0; i < queenNum; i++) {
            if (put[i][col] == 1) return false;
        }

        // 检查斜线上是否有棋子
        int i = 0, j = 0;
        i = row - Math.min(row, col);
        j = col - Math.min(row, col);
        while (i < queenNum && j < queenNum) {
            if (put[i++][j++] == 1) return false;
        }
        i = row + Math.min(queenNum - 1 - row, col);
        j = col - Math.min(queenNum - 1 - row, col);
        while (i >= 0 && j < queenNum) {
            if (put[i--][j++] == 1) return false;
        }
        return true;
    }

    public static StringBuffer initializeStringBufferWithDots(int n) {
        if (n <= 0) {
            return new StringBuffer(); // 返回空的StringBuffer
        }

        char[] dots = new char[n];
        java.util.Arrays.fill(dots, '.');
        return new StringBuffer(new String(dots));
    }
}
