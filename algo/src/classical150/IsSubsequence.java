package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-03 9:00
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence s = new IsSubsequence();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int tLen = t.length();
        int sLen = s.length();
        int p = 0;
        for(int i = 0; i < tLen; i++){
            if(p < sLen && t.charAt(i) == s.charAt(p)){
                ++p;
            }
        }
        if(p > sLen - 1){
            return true;
        }
        return false;
    }
}
