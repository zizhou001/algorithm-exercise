package heat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 使用哈希+指针
 * 1. 两个哈希表，分别存储当前  检索字符情况 和  目标字符包含情况
 * 2. 两个指针：
 *  右指针不断向右，直到包含
 *  左指针向左，寻找最小集合，直到不包含
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-25 15:01
 */
public class MinWindow {

    private HashMap<Character, Integer> tMap = new HashMap<>();
    private HashMap<Character, Integer> cMap = new HashMap<>();

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int left = 0, right = -1;
        int ansL = -1, ansR = -1;
        int len = Integer.MAX_VALUE;

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        while (right < sLen) {
            right++;
            if (right < sLen && tMap.containsKey(s.charAt(right))) {
                cMap.put(s.charAt(right), cMap.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (isCovered() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (tMap.containsKey(s.charAt(left))) {
                    cMap.put(s.charAt(left), cMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean isCovered() {
        Iterator<Map.Entry<Character, Integer>> iterator = tMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (cMap.getOrDefault(key, 0) < value) return false;
        }
        return true;
    }

    /**
     * 占用内存较多
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        String ans = "";
        int sLen = s.length(), tLen = t.length();

        char[] chars = t.toCharArray();

        for (char ch : chars) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int left = -1, right = 0;
        boolean moveRight = true;
        int minLen = Integer.MAX_VALUE;
        String curAns = "";
        while (right < sLen) {

            if (moveRight) {
                char c = s.charAt(right);
                cMap.put(c, cMap.getOrDefault(c, 0) + 1);
                if (isCovered()) {
                    moveRight = false;
                    left++;
                    curAns = s.substring(left, right + 1);
                    ans = curAns.length() < minLen ? curAns : ans;
                    minLen = Math.min(curAns.length(), minLen);
                } else {
                    right++;
                }
            }
            if (!moveRight) {
                char c = s.charAt(left);
                cMap.put(c, cMap.getOrDefault(c, 0) - 1);
                if (isCovered()) {
                    left++;
                    curAns = s.substring(left, right + 1);
                    ans = curAns.length() < minLen ? curAns : ans;
                    minLen = Math.min(curAns.length(), minLen);
                } else {
                    moveRight = true;
                    right++;
                }
            }
        }
        return ans;
    }
}
