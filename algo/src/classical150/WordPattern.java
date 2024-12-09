package classical150;

import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-09 10:42
 */
public class WordPattern {

    public static void main(String[] args) {
        WordPattern s = new WordPattern();
        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        for (int i = 0; i < words.length; i++) {
            char key = pattern.charAt(i);
            String word = words[i];
            if (map.isEmpty()) {
                map.put(key, word);
            }else if (!map.containsKey(key) && !map.containsValue(word)){
                map.put(key, word);
            }else if (map.containsKey(key) && !map.get(key).equals(word)){
                return false;
            }else if (!map.containsKey(key) && map.containsValue(word)){
                return false;
            }
        }
        return true;
    }
}
