package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-09 11:31
 */
public class IsHappy {

    public static void main(String[] args) {
        IsHappy s = new IsHappy();
        System.out.println(s.isHappy(19));
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
