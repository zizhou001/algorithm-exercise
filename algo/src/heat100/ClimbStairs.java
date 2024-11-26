package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-21 8:41
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs s = new ClimbStairs();
        System.out.println(s.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] climb = new int[n + 1];
        climb[1] = 1;
        climb[2] = 2;
        for (int i = 3; i <= n; i++) {
            climb[i] = climb[i - 1] + climb[i - 2];
        }
        return climb[n];
    }
}
