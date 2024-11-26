package heat100;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-25 15:57
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber(new int[]{2, 2, 1}));
    }

    /**
     * 1. 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 2. 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 3. 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums){
            single ^= num;
        }
        return single;
    }

}
