package classical150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-02 10:42
 */
public class FullJustify {

    public static void main(String[] args) {
        FullJustify s = new FullJustify();
        String[] word = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> ans = s.fullJustify(word, maxWidth);
        ans.forEach(System.out::println);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int length = words.length;

        int curWidth = 0;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历所有单词
        while (i < length) {
            String word = words[i];
            // 记录当前单词开始填充的起始位置，若当前行填补不完，需要删除
            int startIdx = stringBuilder.length();
            int j = 0;
            // 填充单词的每一个字母
            while (j < word.length()) {
                if (curWidth < maxWidth){
                    stringBuilder.append(word.charAt(j));
                    ++curWidth;
                    ++j;
                }else {
                    break;
                }
            }
            if (j != word.length()){  // 单词没有填充完
                // 删除已经填充的
                stringBuilder.delete(startIdx, stringBuilder.length());
                // 调整格式后加入结果集
                ans.add(justify(stringBuilder, maxWidth, false));
                // 清除builder，以防影响下一行
                stringBuilder.delete(0, stringBuilder.length());
                // 长度归零
                curWidth = 0;
            }else { // 填充了完整单词
                stringBuilder.append(' ');
                ++curWidth;
                ++i;
                if (i >= length){
                    // 所有单词都遍历完了，处理最后一行的格式，并加入结果集
                    ans.add(justify(stringBuilder, maxWidth, true));
                }
            }
        }
        return ans;
    }

    private String justify(StringBuilder builder, int maxWidth, boolean lastRow){

        // 删除每一行末尾的空格
        while (builder.charAt(builder.length() - 1) == ' '){
            builder.deleteCharAt(builder.length() - 1);
        }

        // 若是最后一行或此行只有一个单词，直接在末尾添加空格
        if (lastRow || builder.indexOf(" ") == -1){
            while (builder.length() < maxWidth){
                builder.append(' ');
            }
            return builder.toString();
        }

        int i = 0;
        // 保证添加的空格均匀
        boolean added = false;

        while (builder.length() < maxWidth){
            // 若发现空格，并且在这个空格位置没添加过空格才添加空格
            if (builder.charAt(i) == ' ' && !added){
                builder.insert(i, ' ');
                added = true;
            }else if (builder.charAt(i) != ' '){
                added = false;
            }
            ++i;
            if (i == builder.length()){
                i = builder.indexOf(" ");
            }
        }
        return builder.toString();
    }
}
