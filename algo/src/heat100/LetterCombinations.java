package heat100;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-11 14:51
 */
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        List<String> strings = l.letterCombinations("23");
        strings.forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) return combinations;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
                          StringBuffer combination){
        if (index == digits.length()){
            combinations.add(combination.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
