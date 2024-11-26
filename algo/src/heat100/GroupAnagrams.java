package heat100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-22 9:09
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> lists = solution(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
        // System.out.println(sortStr("tea"));
    }

    public static List<List<String>> solution(String[] strs){

        HashMap<String, ArrayList<String>> stringVectorHashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sortedStr = sortStr(strs[i]);
            if (!stringVectorHashMap.containsKey(sortedStr)){
                stringVectorHashMap.put(sortedStr, new ArrayList<>());
            }
            stringVectorHashMap.get(sortedStr).add(strs[i]);
        }

        return stringVectorHashMap.values().stream().map(ArrayList::new).collect(Collectors.toList());
    }

    public static String sortStr(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
