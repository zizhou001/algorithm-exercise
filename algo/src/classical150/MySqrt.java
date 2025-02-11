package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-11 10:31
 */
public class MySqrt {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if((long) mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
}
