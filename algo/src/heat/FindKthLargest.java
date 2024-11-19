package heat;

/**
 * 堆排序：
 * 1. 需要一个记录大小的辅助空间
 * 2. 待排序记录仍然采用向量数组存储，并非采用树形结构
 * 3. 将向量中存储的数据看做完全二叉树，利用其顺序结构的特征进行分析
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-19 8:11
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest s = new FindKthLargest();
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 初始化大根堆：从第一个非叶子节点开始执行，筛选子树中最大值作为根节点的值
        // 结果：nums[0]存放最大值
        for (int i = len / 2  - 1; i >= 0 ; --i) {
            sift(nums, i, len);
        }

        // 每次将最大值交换到数组尾部（在数组中的大小关系已经确定，不参与排序）
        // 继续筛选其余元素,调整堆
        int tmp = 0;
        for (int i = len - 1; i >= 1; --i) {
            tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            sift(nums, 0, i);
        }
        return nums[len - 1 - (k - 1)];
    }

    void sift(int[] nums, int rootIdx, int n) {
        // 保存根的值（待填充值，待调整值）
        int rootVal = nums[rootIdx];
        // 默认先找做子节点
        int childIdx = 2 * rootIdx + 1;
        boolean finished = false;
        while (childIdx < n && !finished) {
            // 检查右子节点的值是否更大,选择更大的节点值
            if (childIdx + 1 < n && nums[childIdx] < nums[childIdx + 1]) {
                childIdx = childIdx + 1;
            }
            // 根节点已经大于左右子节点,结束
            if (rootVal > nums[childIdx]){
                finished = true;
            }
            // 否则，将当前根节点值替换左右子树中较大的值，继续筛选
            else {
                nums[rootIdx] = nums[childIdx];
                rootIdx = childIdx;
                childIdx = 2 * rootIdx + 1;
            }
        }
        // 结束后，将要调整的值填充到目标位置
        nums[rootIdx] = rootVal;
    }
}
