package classical150;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-02 9:48
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords s = new ReverseWords();
        System.out.println(s.reverseWords(" a good   example "));
    }

    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
