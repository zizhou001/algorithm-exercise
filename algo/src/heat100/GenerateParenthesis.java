package heat100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-11 16:06
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis s = new GenerateParenthesis();
        List<String> strings = s.generateParenthesis(3);
        strings.forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        backtrack(ans, buffer, 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuffer buffer, int left, int right, int target) {
        if (left > target || right > target) {
            return;
        }

        if (left == target && right == target) {
            ans.add(buffer.toString());
            return;
        }

        buffer.append('(');
        backtrack(ans, buffer, left + 1, right, target);
        buffer.deleteCharAt(left + right);

        if (left > right) {
            buffer.append(')');
            backtrack(ans, buffer, left, right + 1, target);
            buffer.deleteCharAt(left + right);
        }
    }
}
