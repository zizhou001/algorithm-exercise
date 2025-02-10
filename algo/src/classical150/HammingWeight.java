package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-10 10:08
 */
public class HammingWeight {

    /**
     * 「Brian Kernighan 算法」，
     * 它用于清除二进制串中最右边的 1。
     * 核心：n = n & (n - 1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0){
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
