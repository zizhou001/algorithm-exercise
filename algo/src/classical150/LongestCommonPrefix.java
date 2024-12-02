package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-02 9:28
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix s = new LongestCommonPrefix();
        System.out.println(s.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        String minStr = strs[0];
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
            minStr = s;
        }
        String ans = "";
        for (int i = 0; i < minStr.length(); i++) {
            String substring = minStr.substring(0, i + 1);
            int j = 0;
            while (j < strs.length && strs[j].startsWith(substring)) {
                ++j;
            }
            if (j != strs.length) {
                break;
            } else {
                ans = substring;
            }
        }
        return ans;
    }
}
