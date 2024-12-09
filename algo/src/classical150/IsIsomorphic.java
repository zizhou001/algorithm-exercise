package classical150;

import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-09 9:57
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        IsIsomorphic s = new IsIsomorphic();
        System.out.println(s.isIsomorphic("badc", "babc"));
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(s.charAt(0), t.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!map.containsKey(sChar) && !map.containsValue(tChar)) {
                // 不存在任何映射，添加映射
                map.put(sChar, tChar);
            } else if (map.containsKey(sChar) && map.get(sChar) != tChar){
                // 存在已有映射，验证映射
                return false;
            } else if (!map.containsKey(sChar) && map.containsValue(tChar)){
                // value已经被映射
                return false;
            }
        }
        return true;
    }
}
