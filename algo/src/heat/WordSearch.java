package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-12 8:48
 */
public class WordSearch {

    boolean ans = false;

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        StringBuffer curWord = new StringBuffer();
        int[][] selected = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /* if (board[i][j] == word.charAt(0)) {
                    backtrack(board, selected, curWord, word, i, j, 0);
                } */
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public void backtrack(char[][] board, int[][] selected,
                          StringBuffer curWord, String word,
                          int row, int col, int idx) {
        int m = board.length;
        int n = board[0].length;
        if (row >= m || row < 0 || col >= n || col < 0 || idx >= word.length()) {
            if (curWord.toString().equals(word)) {
                ans = true;
            }
            return;
        }
        char ch = word.charAt(idx);
        if (board[row][col] == ch && selected[row][col] == 0) {

            selected[row][col] = 1;
            curWord.append(ch);

            backtrack(board, selected, curWord, word, row, col + 1, idx + 1);
            backtrack(board, selected, curWord, word, row + 1, col, idx + 1);
            backtrack(board, selected, curWord, word, row, col - 1, idx + 1);
            backtrack(board, selected, curWord, word, row - 1, col, idx + 1);

            curWord.deleteCharAt(idx);
            selected[row][col] = 0;
        }
    }

    public boolean dfs(char[][] board, String word, int row, int col, int pos) {
        if (pos == word.length()) return true;
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(pos))
            return false;
        board[row][col] = ' ';
        if (dfs(board, word, row, col + 1, pos + 1)
                || dfs(board, word, row, col - 1, pos + 1)
                || dfs(board, word, row + 1, col, pos + 1)
                || dfs(board, word, row - 1, col, pos + 1)) {
            return true;
        }
        board[row][col] = word.charAt(pos);
        return false;
    }
}
