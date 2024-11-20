package heat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-20 12:01
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels s = new PartitionLabels();
        List<Integer> ans = s.partitionLabels("ababcbacadefegdehijhklij");
        ans.forEach(System.out::println);
    }

    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int length = s.length();
        int[][] mark = new int[26][2];
        for (int i = 0; i < mark.length; i++) {
            mark[i][0] = -1;
            mark[i][1] = -1;
        }
        for (int i = 0; i < length; i++) {
            int[] meta = mark[s.charAt(i) - 'a'];
            if (meta[0] == -1) {
                meta[0] = i;
            } else {
                meta[1] = i;
            }
        }

        int left = mark[s.charAt(0) - 'a'][0];
        int right = mark[s.charAt(0) - 'a'][1] == -1 ? left : mark[s.charAt(0) - 'a'][1];
        for (int i = 1; i < length; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (i < right && mark[idx][1] > right){
                right = mark[idx][1];
            }else if (i > right && mark[idx][0] > right) {
                ans.add(right - left + 1);
                left = mark[idx][0];
                right = mark[idx][1] == -1 ? mark[idx][0] : mark[idx][1];
            }
        }
        ans.add(right - left + 1);
        return ans;
    }
}
