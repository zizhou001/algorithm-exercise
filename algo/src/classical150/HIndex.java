package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-28 10:04
 */
public class HIndex {
    public static void main(String[] args) {
        HIndex s = new HIndex();
        int[] c = {3, 0, 6, 1, 5};
        System.out.println(s.hIndex(c));
    }

    public int hIndex(int[] citations) {
        int num = citations.length;
        int ans = 0;
        int[] counter = new int[num + 1];

        // 计数
        for (int i = 0; i < num; i++) {
            counter[Math.min(citations[i], num)] += 1;
        }

        // 从后向前遍历计数数组
        for (int i = num; i >=0 ; i--) {
            ans += counter[i];

            if (ans >= i) return i;
        }
        return 0;
    }
}
