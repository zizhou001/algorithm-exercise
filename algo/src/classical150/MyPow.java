package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-11 10:40
 */
public class MyPow {

    public double myPow(double x, int n) {
        Long N = (long)n;
        return n >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);

    }

    public double quickMul(double x, long N){
        if(N == 0){
            return 1.0;
        }

        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
