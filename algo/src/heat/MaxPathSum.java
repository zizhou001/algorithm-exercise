package heat;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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
        fun(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;
    TreeSet<Integer> ans = new TreeSet<>();
    public int fun(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(fun(root.left), 0);
        int rightSum = Math.max(fun(root.right), 0);
        int priceNewPath = root.val + leftSum + rightSum;
        maxSum = Math.max(priceNewPath, maxSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
