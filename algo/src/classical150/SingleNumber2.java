package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-10 11:08
 */
public class SingleNumber2 {

    /**
     * 思路：
     * 1. 假设数组中的所有数都可以用4位表示 0000
     * 2. 若每个数字都恰好出现3次，统计所有数字后，所有位上的 1 的个数都可以被3整除
     * 3. 加入一个只出现1次的数字后，1的个数不能被3整除的二进制位，必然是新加入数字影响的
     * 4. 本质上是统计每个二进制位1的个数的变化、
     * 5. 用a,b表示每一位上1的个数，例如01表示有1个
     * (A+B)' = A'B'
     * (AB)' = A' + B'
     * A'B + AB' = A ⊕ B
     * <p>
     * a    b   x   | na  nb
     * ---------------------
     * 0    0   0   | 0   0
     * 0    0   1   | 0   1
     * 0    1   0   | 0   1
     * 0    1   1   | 1   0
     * 1    0   0   | 1   0
     * 1    0   1   | 0   0
     * <p>
     * na = a'bx + ab'x' = (~a & b & x) | (a & ~b & ~x)
     * nb = a'b'x + a'bx' = a'(b'x+bx') = a'(b ⊕ x) = ~a & (b ^ x)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            int aNext = (~a & b & x) | (a & ~b & ~x);
            int bNext = ~a & (b ^ x);
            a = aNext;
            b = bNext;
        }
        return b;
    }
}
