package classical150;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-05 11:06
 */
public class FindWords {

    int R;
    int C;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        FindWords s = new FindWords();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = s.findWords(board, words);
        res.forEach(System.out::println);
    }

    public List<String> findWords(char[][] board, String[] words) {
        R = board.length;
        C = board[0].length;
        Trie2 root = new Trie2();

        for(String word : words){
            root.insert(word);
        }

        Set<String> ans = new HashSet<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                dfs(board, root, i, j, ans);
            }
        }
        return new ArrayList<String>(ans);
    }

    public void dfs(char[][] board, Trie2 node, int r, int c, Set<String> ans){
        if(!node.children.containsKey(board[r][c])){
            return;
        }
        char ch = board[r][c];
        node = node.children.get(ch);
        if(!"".equals(node.word)){
            ans.add(node.word);
        }

        board[r][c] = '#';
        for(int[] dir : dirs){
            int nr = r + dir[0], nc = c + dir[1];
            if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                dfs(board, node, nr, nc, ans);
            }
        }

        board[r][c] = ch;
    }
}

class Trie2 {
    /**
     * 当且仅当该节点是某个单词最后一个字母节点时
     * 才存储word，否则为空
     */
    String word;
    Map<Character, Trie2> children;
    boolean isWord;

    public Trie2() {
        this.word = "";
        this.children = new HashMap<Character, Trie2>();
    }

    public void insert(String word) {
        Trie2 cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie2());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}
