package nk;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-16 10:31
 * @since JDK 17
 */
public class ReversePairsInArray {

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 冒泡排序时间复杂度较高
     *
     * @param nums
     * @return
     */
    public static int solutionWithBubble(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    count++;
                    swap(nums, j, j + 1);
                }
            }
        }
        return count % 1000000007;
    }


    /**
     * 使用归并排序计算
     *
     * @param nums
     * @return
     */
    public static int solutionWithMerge(int[] nums){
        long count = mergeSortAndCount(nums, 0, nums.length - 1);
        return (int) (count % 1000000007);
    }

    public static long mergeSortAndCount(int[] array, int left, int right) {
        // 递归调用出口
        if (left >= right) return 0;

        // 找到中间索引，这种方式可以防止Integer类型（left + right）溢出
        int mid = left + (right - left) / 2;

        // 计算左半部分和右半部分的和
        long count = mergeSortAndCount(array, left, mid) + mergeSortAndCount(array, mid + 1, right);

        // 合并左半部分和右半部分
        count += mergeAndCount(array, left, mid, right);

        return count;
    }

    public static long mergeAndCount(int[] array, int left, int mid, int right) {

        // 拆分原数组
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        // 复制到临时数组
        System.arraycopy(array, left, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid + 1, rightArray, 0, rightArray.length);

        // 合并过程
        int i = 0, j = 0, k = left;
        long count = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) array[k++] = leftArray[i++];
            else {
                array[k++] = rightArray[j++];
                // leftArray是有序的，若leftArray[i] > rightArray[j]，
                // leftArray中剩余元素都与rightArray中的元素形成逆序数对
                count += (leftArray.length - i);
            }
        }

        // 复制剩余元素
        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];

        // 返回合并计数结果
        return count;
    }


    public static void main(String[] args) {

        System.out.println(solutionWithMerge(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
        System.out.println(solutionWithMerge(new int[]{4, 2, 3, 1, 9, 6, 7, 0}));
        System.out.println(solutionWithMerge(new int[]{1, 2, 3}));

    }
}
