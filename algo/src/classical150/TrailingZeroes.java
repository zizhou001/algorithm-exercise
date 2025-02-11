package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-11 10:21
 */
public class TrailingZeroes {

    /**
     * 统计有多少个5
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }


    public int trailingZeroes0(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i++) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ans++;
            }
        }
        return ans;
    }
}
