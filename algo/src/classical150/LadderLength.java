package classical150;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-01-17 16:15
 */
public class LadderLength {

    public static void main(String[] args) {
        LadderLength s = new LadderLength();
        System.out.println(s.ladderLength("hit", "cog",
                Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    }

    Map<String, List<String>> edges = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdges(word);
        }
        addEdges(beginWord);

        if (!edges.containsKey(endWord)) {
            return 0;
        }

        Map<String, Integer> step = new HashMap<>();
        step.put(beginWord, 0);

        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String curWord = queue.poll();

            if (curWord.equals(endWord)) {
                return step.get(curWord) / 2 + 1;
            }

            for (String w : edges.get(curWord)) {
                if (!step.containsKey(w)) {
                    step.put(w, step.get(curWord) + 1);
                    queue.offer(w);
                }
            }
        }
        return 0;
    }

    public void addEdges(String word) {
        if (!edges.containsKey(word)) {
            edges.put(word, new ArrayList<>());
        }

        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char tmp = charArray[i];
            charArray[i] = '*';
            String newWord = new String(charArray);
            edges.get(word).add(newWord);
            if (!edges.containsKey(newWord)) {
                edges.put(newWord, new ArrayList<>());
            }
            edges.get(newWord).add(word);
            charArray[i] = tmp;
        }

    }
}

