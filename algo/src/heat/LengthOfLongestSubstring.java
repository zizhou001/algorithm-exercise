package heat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

/**
 * 关键点：
 *  1. 使用滑动窗口HashSet记录不重复的连续子串
 *  2. 定义left和right遍历字符串
 *      1）重复，缩left
 *      2）不重复，扩right
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-24 14:21
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "au";
        System.out.println(lengthOfLongestSubstring(s1));
    }

    public static int lengthOfLongestSubstring2(String s) {
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

    /**
     * 通过，但复杂度较高
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        Vector<Character> vector = new Vector<>();
        for (char c : s.toCharArray()) {
            vector.add(c);
        }
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = vector.size();
        int longest = 0;
        int cur = 0;

        for (int i = 0; i < len; ) {
            Character c = vector.get(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                ++i;
                cur++;
            } else {
                longest = Math.max(cur, longest);
                cur = 0;
                i = map.get(c) + 1;
                map.clear();
            }
        }
        longest = Math.max(cur, longest);
        return longest;
    }


}
