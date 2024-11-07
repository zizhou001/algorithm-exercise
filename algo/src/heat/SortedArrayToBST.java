package heat;

import utils.TreeNode;

/**
 * 思路：总是选择nums[mid]作为root
 *
 * 平衡：height(node.left) - height(node.right) <= 1
 * 搜索：left.val <= node.val < right.val
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 16:39
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST solution = new SortedArrayToBST();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
