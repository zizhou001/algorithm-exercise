package heat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-24 15:48
 */
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) return new ArrayList<Integer>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        char[] chars = s.toCharArray();

        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        ArrayList<Integer> res = new ArrayList<>();

        if (Arrays.equals(sCount, pCount)) res.add(0);

        for (int i = 0; i < sLen - pLen; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
