package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-11 8:32
 */
public class Trie {

    Node root = null;

    class Node{
        boolean isEnd;
        Node[] children;

        Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.children[idx] == null){
                Node node = new Node();
                p.children[idx] = node;
                p = node;
            }else {
                p = p.children[idx];
            }
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Node searchPrefix(String prefix){
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (p.children[idx] == null) return null;
            p = p.children[idx];
        }
        return p;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app"));         // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}
