package classical150;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-27 8:50
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] num1 = {4, 5, 6, 0, 0, 0};
        int[] num2 = {1, 2, 3};
        int m = 3, n = 3;
        MergeSortedArray s = new MergeSortedArray();
        s.merge(num1, m, num2, n);
        for (int e : num1) {
            System.out.print(e + " ");
        }
    }

    /**
     * 从后往前填充
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int end = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[end] = nums2[p2];
                --p2;
                --end;
            } else {
                nums1[end] = nums1[p1];
                --p1;
                --end;
            }
        }
        while (p2 >= 0) {
            nums1[end--] = nums2[p2--];
        }
    }
}
