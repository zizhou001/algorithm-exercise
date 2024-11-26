package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-25 16:03
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement s = new MajorityElement();
        System.out.println(s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums){
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
