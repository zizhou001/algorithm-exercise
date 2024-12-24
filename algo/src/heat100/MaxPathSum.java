package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

/**
 * 二叉树中的最大路径和。
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-07 14:31
 */
public class MaxPathSum {



    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        MaxPathSum s = new MaxPathSum();
        System.out.println(s.maxPathSum(root));
    }

    /**
     * 通过
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    /**
     *
     * @param root
     * @return 节点node的最大price
     */
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // 左右子树的“增益”，最小为0
        int leftSum = Math.max(dfs(root.left), 0);
        int rightSum = Math.max(dfs(root.right), 0);
        // 新路径 left -> root -> right
        int priceNewPath = root.val + leftSum + rightSum;
        // 比对新路径是否大于当前的路径
        maxSum = Math.max(priceNewPath, maxSum);
        // 返回当前节点的最大price（即，当某条路径经过root时，走左子树或右子树时产生的最大收益）
        return root.val + Math.max(leftSum, rightSum);
    }
}
