package classical150;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-11 11:09
 */
public class Calculator {

    Deque<Character> symbolStk = new ArrayDeque<>();
    Deque<Integer> integerStk = new ArrayDeque<>();

    public static void main(String[] args) {
        Calculator s = new Calculator();
        // "1-(     -2)"
        // "2-(5-6)"
        // "- (3 - (- (4 + 5) ) )"
        // " 2-1 + 2 "
        System.out.println(s.calculate(" 2-1 + 2 "));
    }

    public int calculate2(String s){
        // 例如，对于"- (3 - (- (4 + 5) ) )"
        // 当前表达式："- (3 - (- (4 + 5) ) )"，初始状态可以看做"(    - (3 - (- (4 + 5) ) )     )"
        // 下一个子表达式："(3 - (- (4 + 5) ) )"
        // 栈顶存放的是，当前表达式的符号
        // sign：表示当前要累加的整数的符号
        // 遍历到子表达式中时，
        //    （1）遇见'+'，整数num符号与括号外符号一致，例如，对于"-(4+5-7)"中的"5",括号外为负，则累加时应该是"-5"
        //    （2）遇见'-'，变号，例如，对于"-(4+5-7+8)"中的"7"，累加时应该是"- -7" 即，"7"
        //    （3）遇见'('，当前括号符号入栈
        //    （4）遇见')'，当前括号遍历完毕，符号使用完毕，出栈
        Deque<Integer> ops = new ArrayDeque<>();
        // 默认为正，即 1 * n = n
        ops.push(1);
        // 表示当前要累加的整数的符号
        int sign = 1;
        // 存储累加的结果
        int ret = 0;

        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public int calculate(String s) {
        HashMap<Character, Integer> seqMap = new HashMap<>();
        seqMap.put('(', 3);
        seqMap.put(')', 3);
        seqMap.put('-', 2);
        seqMap.put('+', 2);
        seqMap.put('*', 1);
        seqMap.put('/', 1);

        s = s.replaceAll(" ", "");
        int len = s.length();
        for (int i = 0; i < len; ) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                integerStk.push(num);
            } else if (ch == '(') {
                symbolStk.push(ch);
                ++i;
            } else if (ch == ')') {
                while (!symbolStk.isEmpty() && symbolStk.peek() != '(') {
                    integerStk.push(calExpression(symbolStk.pop()));
                }
                symbolStk.pop();
                ++i;
            } else if (!symbolStk.isEmpty() && seqMap.get(ch) >= seqMap.get(symbolStk.peek())) {
                integerStk.push(calExpression(symbolStk.pop()));
                symbolStk.push(ch);
                ++i;
            } else {
                if ((i == 0 || s.charAt(i + 1) == ')') && ch == '-'){
                    integerStk.push(0);
                }
                symbolStk.push(ch);
                ++i;
            }
        }
        while (!integerStk.isEmpty() && !symbolStk.isEmpty()) {
            integerStk.push(calExpression(symbolStk.pop()));
        }
        return integerStk.peek();
    }

    private int calExpression(char operator) {
        int operand2 = integerStk.pop();
        int operand1 = integerStk.pop();
        switch (operator) {
            case '-': {
                return operand1 - operand2;
            }
            case '+': {
                return operand1 + operand2;
            }
            case '/': {
                return operand1 / operand2;
            }
            case '*': {
                return operand1 * operand2;
            }
        }
        return 0;
    }
}
