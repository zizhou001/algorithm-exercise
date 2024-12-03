package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-03 9:16
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] numbers = {12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180,
                199, 212, 221, 227, 230, 277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370,
                371, 375, 384, 387, 394, 400, 404, 414, 422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541,
                546, 568, 583, 585, 587, 650, 652, 677, 691, 730, 737, 740, 751, 755, 764, 778, 783, 785, 789, 794,
                803, 809, 815, 847, 858, 863, 863, 874, 887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997};
        int t = 542;
        int[] ans = s.twoSum(numbers, t);
        for (int e : ans) {
            System.out.print(e + " ");
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int slow = 0, fast = 1;
        int len = numbers.length;

        // 令快指针先走，到达问题边界
        while (fast < len && numbers[slow] + numbers[fast] < target) {
            ++fast;
        }

        if (fast > len - 1 || numbers[slow] + numbers[fast] > target) {
            --fast;
            while (true){
                if (numbers[slow] + numbers[fast] == target) {
                    return new int[]{++slow, ++fast};
                } else if (numbers[slow] + numbers[fast] < target){
                    ++slow;
                } else {
                    --fast;
                }
            }
        } else if (numbers[slow] + numbers[fast] == target) {
            return new int[]{++slow, ++fast};
        }
        return new int[]{0, 0};
    }
}
