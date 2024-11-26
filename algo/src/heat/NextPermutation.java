package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-26 9:09
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation s = new NextPermutation();
        int[] nums = {1, 3, 2};
        s.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 本质是寻找下一个最小的、比当前数组元素顺序组成的整数大的下一个整数
     * 例如，对于{1,3,2}，组成的整数是132，下一个比他大的是213
     * <p>
     * 过程：以1, 2, 3, 8, 5, 7, 6, 4为例
     * 1. 找到第一个产生降序的元素为5，下标为targetIdx = 4
     * 2. 从后往前,当num[i] > nums[targetIdx]时，交换，此时：1, 2, 3, 8, 6, 7, 5, 4
     * 3. 把targetIdx后的元素设置为升序（保证最小），此时：1, 2, 3, 8, 6, 4, 5, 7
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int targetIdx = -1;
        // 从后往前，寻找第一对降序
        for (int i = n - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1]) {
                targetIdx = i - 1;
                break;
            }
        }
        // 未找到降序，不存在下一个序列，直接倒置数组
        if (targetIdx == -1) {
            reverseArray(nums, 0, n - 1);
        } else {
            // 从后往前，寻找第一个比要替换数字大的
            for (int j = n - 1; j >= targetIdx; --j) {
                if (nums[j] > nums[targetIdx]) {
                    swap(nums, j, targetIdx);
                    break;
                }
            }
            // 倒置 nums(targetIdx, end]
            reverseArray(nums, targetIdx + 1, n - 1);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void reverseArray(int[] nums, int begin, int end) {
        int i = begin;
        int j = end;
        while (i <= j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }
}
