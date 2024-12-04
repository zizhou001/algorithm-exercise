package classical150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-04 12:00
 */
public class MinWindow {

    public static void main(String[] args) {
        MinWindow s = new MinWindow();
        System.out.println(s.minWindow("a", "aa"));
    }
    HashMap<Character, Integer> tMap = new HashMap<>();
    HashMap<Character, Integer> sMap = new HashMap<>();


    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        for (int i = 0; i < tLen; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int right = 0, left = 0;
        int ansL = -1, ansR = -1;
        int len = Integer.MAX_VALUE;
        while (right < sLen) {
            char ch = s.charAt(right);
            if (tMap.containsKey(ch)){
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            }
            while (covered() && left <= right){
                if (right - left + 1 < len){
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (tMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }
            ++right;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean covered(){
        for(Map.Entry<Character, Integer> entry : tMap.entrySet()){
            if (entry.getValue() > sMap.getOrDefault(entry.getKey(), 0)){
                return false;
            }
        }
        return true;
    }
}
