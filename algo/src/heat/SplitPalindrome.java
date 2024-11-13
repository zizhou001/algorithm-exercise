package heat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-12 9:43
 */
public class SplitPalindrome {

    List<List<String>> res = new ArrayList<>();
    List<String> parts = new ArrayList<>();

    public static void main(String[] args) {
        SplitPalindrome s = new SplitPalindrome();
        List<List<String>> ans = s.partition("aabaa");
        ans.forEach(System.out::println);
    }

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return res;
        backtrack(new StringBuilder(s), 0, s.length());
        return res;
    }

    public void backtrack(StringBuilder stringBuilder, int startIdx, int length) {
        if (startIdx == length) {
            res.add(new ArrayList<>(parts));
            return;
        }
        for (int i = startIdx; i < length; i++) {
            String substring = stringBuilder.substring(startIdx, i + 1);
            if (isPalindrome(substring)){
                parts.add(substring);
                backtrack(stringBuilder, i + 1, length);
                parts.remove(parts.size() - 1);
            }
        }
        return;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
