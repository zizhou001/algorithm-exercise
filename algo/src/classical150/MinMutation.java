package classical150;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-01-17 15:10
 */
public class MinMutation {

    public static void main(String[] args) {
        MinMutation s = new MinMutation();
        // System.out.println(s.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC",
        //         "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"}));

        char ch = 'a' + 2;
        System.out.println(ch);
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        int bLen = bank.length;
        if (bLen == 0) {
            return -1;
        }
        char[] items = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();

        List<String> bankList = Arrays.stream(bank).collect(Collectors.toList());

        Deque<Status> queue = new LinkedList<>();
        queue.offer(new Status(startGene, 0));
        set.add(startGene);
        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            String gene = cur.gene;
            int step = cur.step;

            for (int i = 0; i < 8; i++) {
                StringBuilder builder = new StringBuilder(gene);
                for (char item : items) {

                    if (item != builder.charAt(i)) {
                        builder.setCharAt(i, item);
                        String updated = builder.toString();

                        if (bankList.contains(updated) && !set.contains(updated)) {
                            if(updated.equals(endGene)){
                                return step + 1;
                            }
                            set.add(updated);
                            queue.offer(new Status(updated, step + 1));
                        }
                    }
                }

            }
        }
        return -1;
    }
}

class Status {
    String gene;
    int step;

    Status(String gene, int step) {
        this.gene = gene;
        this.step = step;
    }
}
