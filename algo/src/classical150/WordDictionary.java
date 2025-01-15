package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-01-06 15:26
 */

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word){
        Trie node = this;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx =  ch - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }

        node.isEnd = true;
    }

    public Trie[] getChildren(){
        return this.children;
    }

    public boolean isEnd(){
        return this.isEnd;
    }
}

public class WordDictionary {

    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");

        dictionary.search("a.");

    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Trie node){
        if(idx == word.length()){
            return node.isEnd();
        }

        char ch = word.charAt(idx);
        if(Character.isLetter(ch)){
            int childrenIdx = ch - 'a';
            Trie child = node.getChildren()[childrenIdx];
            if(child != null && dfs(word, idx + 1, child)){
                return true;
            }
        }else{
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if(child != null && dfs(word, idx + 1, child)){
                    return true;
                }
            }
        }

        return false;
    }
}
