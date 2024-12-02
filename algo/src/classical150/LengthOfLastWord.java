package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-02 9:26
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord s = new LengthOfLastWord();
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {
        String str =s.trim();
        int idx = str.lastIndexOf(' ');
        return str.substring(idx + 1, str.length()).length();
    }
}
