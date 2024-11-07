package mysort;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-16 14:51
 * @since JDK 17
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 6, 81, 3};
        mergeSort(array, 0, array.length - 1);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);

        return;
    }

    private static void merge(int[] array, int left, int mid, int right) {

        // 1. 创建临时数组
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        // 2. 复制数据到临时数组
        System.arraycopy(array, left, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid + 1, rightArray, 0, rightArray.length);

        // 3.初始化索引
        int i = 0, j = 0, k = left;

        // 4.合并
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) array[k++] = leftArray[i++];
            else array[k++] = rightArray[j++];
        }

        // 5.复制剩余元素
        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }
}
