package classical150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-11 10:18
 */
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        String path = "/a/../../b/../c//.//";
        s.simplifyPath(path);
        System.out.println(path);
    }

    public String simplifyPath(String path) {
        String[] words = path.split("/+");
        Deque<String> stk = new ArrayDeque<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(word.isEmpty() || word.equals(".")) continue;
            if(word.equals("..")){
                if(stk.isEmpty()){
                    continue;
                }else{
                    stk.pop();
                }
            }else{
                stk.push(word);
            }
        }
        StringBuilder builder = new StringBuilder();
        if(stk.isEmpty()){
            return "/";
        }
        while(!stk.isEmpty()){
            builder.insert(0, stk.pop());
            builder.insert(0, "/");
        }
        return builder.toString();
    }
}
