package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-03 8:55
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome s = new IsPalindrome();
        System.out.println(s.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0, end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
