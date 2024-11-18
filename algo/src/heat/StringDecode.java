package heat;

import javax.sound.sampled.Line;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-18 9:21
 */
public class StringDecode {

    public static void main(String[] args) {
        StringDecode s = new StringDecode();
        System.out.println(s.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public String decodeString(String s){
        int idx = 0;
        Deque<String> stack = new LinkedList<>();
        while (idx < s.length()){
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)){
                StringBuffer digitStrBuffer = new StringBuffer();
                while (Character.isDigit(s.charAt(idx))){
                    digitStrBuffer.append(s.charAt(idx++));
                }
                stack.push(digitStrBuffer.toString());
            }else if (Character.isLetter(ch) || ch == '['){
                stack.push(String.valueOf(s.charAt(idx++)));
            }else {
                ++idx;
                StringBuffer strBuffer = new StringBuffer();
                while (!"[".equals(stack.peek())){
                    strBuffer.insert(0, stack.pop());
                }
                // pop [
                stack.pop();
                int repNum = Integer.parseInt(stack.pop());
                StringBuffer duplicatedStrBuffer = new StringBuffer();
                while (repNum-- > 0){
                    duplicatedStrBuffer.append(strBuffer);
                }
                stack.push(duplicatedStrBuffer.toString());
            }
        }
        StringBuffer ans = new StringBuffer();
        for (String sub : stack){
            ans.insert(0, sub);
        }
        return ans.toString();
    }

    public String decodeString1(String s) {
        Deque<String> stringsStack = new LinkedList<>();
        Deque<Integer> numsStack = new LinkedList<>();
        StringBuffer ans = new StringBuffer();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) && i == 0) {
                int j = i;
                while (j < s.length() && Character.isLetter(s.charAt(j))) {
                    ans.append(s.charAt(j++));
                }
                i = j;
            } else if (Character.isDigit(ch)) {
                int j = i;
                StringBuffer buffer = new StringBuffer();
                while (Character.isDigit(s.charAt(j))) {
                    buffer.append(s.charAt(j++));
                }
                numsStack.push(Integer.valueOf(buffer.toString()));
                i = j;
            } else if (ch == '[') {
                stringsStack.push(String.valueOf(ch));
                int j = i + 1;
                if (j < s.length() && Character.isLetter(s.charAt(j))){
                    while (j < s.length() && Character.isLetter(s.charAt(j))) {
                        stringsStack.push(String.valueOf(s.charAt(j++)));
                    }
                }else {
                    StringBuffer buffer = new StringBuffer();
                    while (Character.isDigit(s.charAt(j))) {
                        buffer.append(s.charAt(j++));
                    }
                    numsStack.push(Integer.valueOf(buffer.toString()));
                }
                i = j;
            } else if (ch == ']') {
                StringBuffer buffer = new StringBuffer();
                while (!stringsStack.peek().equals("[")) {
                    buffer.insert(0, stringsStack.pop());
                }
                stringsStack.pop();
                int repeat = numsStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    tmp.append(buffer.toString());
                }
                if (stringsStack.isEmpty()) {
                    ans.append(tmp);
                } else stringsStack.push(tmp.toString());
                ++i;
            } else {
                if (!stringsStack.isEmpty()) stringsStack.push(String.valueOf(s.charAt(i++)));
                else ans.append(s.charAt(i++));
            }
        }
        return ans.toString();
    }
}
