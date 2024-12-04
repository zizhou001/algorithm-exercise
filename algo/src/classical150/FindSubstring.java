package classical150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-04 9:26
 */
public class FindSubstring {

    public static void main(String[] args) {
        FindSubstring sl = new FindSubstring();
        String[] words = {"bar", "foo", "the"};
        String s = "barfoofoobarthefoobarman";
        List<Integer> ans = sl.findSubstring(s, words);
        ans.forEach(System.out::println);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordsNum = words.length, wordLen = words[0].length(), strLen = s.length();

        /*

         有wordLen中划分方式，每一种都要考虑，例如
         例如，对于字符串：b a r f o o f o o b a r 和 单词组(bar, foo, the)
         - 划分1，从i=0开始划分：bar foo foo bar
         - 划分2，从i=1开始划分：b arf oof oob ar
         - 划分3，从i=2开始划分：ba rfo ofo oba r
         长度刚好为wordLen

         */

        for (int i = 0; i < wordLen; i++) {
            if (i + wordsNum * wordLen > strLen) break;


            // 记录单词出现的频次，记当前考察的s中的子串为str
            HashMap<String, Integer> differ = new HashMap<>();

            // 记录str中单词出现的频次，出现一次，加一次
            for (int j = 0; j < wordsNum; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }

            // 初始化窗口的单词
            // 记录words中单词出现的频次，出现一次，减一次
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }

            /*
             * 执行到此，
             * - 若differ为空：str中单词出现的频次与words中出现频次相同，start是一个解
             * - 若differ.get(word) == 1:     str中出现的频次 > words中出现的频次
             * - 若differ.get(word) == -1:    word并未在str中出现
             * */

            for (int start = i; start < strLen - wordLen * wordsNum + 1; start += wordLen) {
                if (start != i) {

                    // 加入窗口右侧的第一个单词
                    String word = s.substring(start + (wordsNum - 1) * wordLen, start + wordsNum * wordLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }

                    // 移出窗口内最后一个单词（左侧）
                    word = s.substring(start - wordLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}
