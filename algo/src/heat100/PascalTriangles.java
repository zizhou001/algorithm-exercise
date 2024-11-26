package heat100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-21 8:51
 */
public class PascalTriangles {

    public static void main(String[] args) {
        PascalTriangles s = new PascalTriangles();
        List<List<Integer>> ans = s.generate(5);
        ans.forEach(System.out::println);
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (numRows == 1) {
            ans.add(new ArrayList<>(Arrays.asList(1)));
            return ans;
        }
        if (numRows == 2) {
            ans.add(new ArrayList<>(Arrays.asList(1)));
            ans.add(new ArrayList<>(Arrays.asList(1, 1)));
            return ans;
        }
        ans.add(new ArrayList<>(Arrays.asList(1)));
        ans.add(new ArrayList<>(Arrays.asList(1, 1)));
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            List<Integer> pre = ans.get(i - 1);
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}
