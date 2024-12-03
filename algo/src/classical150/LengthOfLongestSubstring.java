package classical150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-03 11:13
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int left = 0, right = 0;

        while (right < n) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                ++left;
            }
            set.add(ch);
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }
}
