package heat;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-14 10:16
 */
public class ValidBracket {

    public static void main(String[] args) {
        ValidBracket s = new ValidBracket();
        System.out.println(s.isValid("(){}}{"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()){
            char ch = s.charAt(i++);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if (ch == ')' && !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else if (ch == ']' && !stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }
                else return false;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
