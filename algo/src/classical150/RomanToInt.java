package classical150;

import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-29 18:26
 */
public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt s = new RomanToInt();
        System.out.println(s.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (i + 1 < length && map.get(ch) < map.get(s.charAt(i + 1))) {
                ans = ans - map.get(ch);
            }else {
                ans = ans + map.get(ch);
            }
        }
        return ans;
    }
}
