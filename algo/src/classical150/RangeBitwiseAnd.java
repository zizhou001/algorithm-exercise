package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-10 11:38
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right){
            right &= (right - 1);
        }
        return right;
    }
}
