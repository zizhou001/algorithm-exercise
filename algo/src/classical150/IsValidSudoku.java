package classical150;

import java.util.HashSet;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-05 8:46
 */
public class IsValidSudoku {

    public static void main(String[] args) {
        IsValidSudoku s = new IsValidSudoku();
        char[][] board =
                         {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(s.isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0){
                set1.clear();
                set2.clear();
                set3.clear();
            }
            int[] rowMark = new int[9];
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                if (rowMark[ch - '1'] == 0){
                    rowMark[ch - '1'] = 1;
                }else {
                    return false;
                }

                if (j < 3){
                    if (set1.contains(ch)){
                        return false;
                    }else {
                        set1.add(ch);
                    }
                }else if (j < 6){
                    if (set2.contains(ch)){
                        return false;
                    }else {
                        set2.add(ch);
                    }
                }else {
                    if (set3.contains(ch)){
                        return false;
                    }else {
                        set3.add(ch);
                    }
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            int[] colMark = new int[9];
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                if (colMark[ch - '1'] == 0){
                    colMark[ch - '1'] = 1;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
