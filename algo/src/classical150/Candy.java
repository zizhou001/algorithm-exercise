package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-29 16:01
 */
public class Candy {

    public static void main(String[] args) {
        Candy s = new Candy();
        System.out.println(s.candy(new int[]{1, 3, 2, 2, 1}));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]){
                left[i] = left[i - 1] + 1;
            }else {
                left[i] = 1;
            }
        }
        int right  = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; --i){
            if (i < n - 1 && ratings[i] > ratings[i + 1]){
                ++right;
            }else {
                right = 1;
            }
            ans += Math.max(left[i], right);
        }
        return ans;
    }
}