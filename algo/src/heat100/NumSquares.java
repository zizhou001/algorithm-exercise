package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-21 10:09
 */
public class NumSquares {

    public static void main(String[] args) {
        NumSquares s = new NumSquares();
        System.out.println(s.numSquares(7));
    }

    /**
     * 假设n=12， 上一个数
     * - 可以是11，因为11 + 1 = 12；1是完全平方数，f[11] = x1
     * - 可以是8， 因为8 + 4 = 12；4是完全平方数,f[8] = x2
     * - 可以是3， 因为3 + 9 = 12；9是完全平方数, f[3] = x3
     * 直到寻找的完全平方数大于等于12，例如16, 虽然 -4 + 16 = 12,但是不符合条件
     * 比较x1, x2, x3 取最小值为x,则f[12] = x + 1
     * 所以，上一个数的范围为：n - j * j (j*j<=n)
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n == 1) return 1;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minNum = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minNum = Math.min(minNum, f[i - j * j]);
            }
            f[i] = minNum + 1;
        }
        return f[n];
    }

}
